package cemtekin.etrade_backend_project.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cemtekin.etrade_backend_project.business.abstracts.CartService;
import cemtekin.etrade_backend_project.business.abstracts.UserService;
import cemtekin.etrade_backend_project.business.requests.CreateCartRequest;
import cemtekin.etrade_backend_project.entities.Cart;
import cemtekin.etrade_backend_project.entities.User;

@RestController
@RequestMapping("api/carts")
public class CartsController {
	private CartService cartService;
	private UserService userService;
	@Autowired
	public CartsController(CartService cartService,UserService userService) {
		this.cartService=cartService;
		this.userService=userService;
	}
		
	@PostMapping("/add")
	public void add(@RequestBody() CreateCartRequest createCartRequest) {
		this.cartService.add(createCartRequest);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.cartService.delete(id);
	}
	@PutMapping("/update")
	public void update(int id,CreateCartRequest createCartRequest) {
		this.cartService.update(id, createCartRequest);
	}
	@GetMapping("/getbyid")
	public Cart getCartById(int id) {
		return this.cartService.getCartById(id);
	}
	@GetMapping("/getbyuser")
	public List<Cart> findByUser(int id){
		User user=userService.getUserById(id);
		return this.cartService.findByUser(user);
	}
}
