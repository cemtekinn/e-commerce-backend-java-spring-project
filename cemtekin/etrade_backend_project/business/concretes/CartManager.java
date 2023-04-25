package cemtekin.etrade_backend_project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cemtekin.etrade_backend_project.business.abstracts.CartService;
import cemtekin.etrade_backend_project.business.requests.CreateCartRequest;
import cemtekin.etrade_backend_project.dataAccess.abstracts.CartRepository;
import cemtekin.etrade_backend_project.entities.Cart;
import cemtekin.etrade_backend_project.entities.User;
@Service
public class CartManager implements CartService{
	private CartRepository cartRepository;
	@Autowired
	public CartManager(CartRepository cartRepository) {
		super();
		this.cartRepository=cartRepository;
	}
	
	@Override
	public void add(CreateCartRequest createCartRequest) {
		Cart cart=new Cart();
		cart.setProduct(createCartRequest.getProduct());
		cart.setQuantity(createCartRequest.getQuantity());
		cart.setUser(createCartRequest.getUser());
		this.cartRepository.save(cart);		
	}
	
	@Override
	public void update(int id, CreateCartRequest createCartRequest) {
		Cart cart=getCartById(id);
		cart.setQuantity(createCartRequest.getQuantity());
		this.cartRepository.save(cart);
	}
	@Override
	public void delete(int id) {
		cartRepository.deleteById(id);		
	}
	@Override
	public Cart getCartById(int id) {
		Cart cart=cartRepository.findById(id).get();
		return cart;
	}
	@Override
	public List<Cart> findByUser(User user){
		List<Cart> carts=cartRepository.findByUser(user);
		return carts;
	}
	
		
	
}
