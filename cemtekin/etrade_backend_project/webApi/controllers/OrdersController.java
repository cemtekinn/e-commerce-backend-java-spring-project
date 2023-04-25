package cemtekin.etrade_backend_project.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cemtekin.etrade_backend_project.business.abstracts.OrderService;
import cemtekin.etrade_backend_project.business.requests.CreateOrderRequest;
import cemtekin.etrade_backend_project.entities.Order;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
	private OrderService orderService;
	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService=orderService;
	}
	@PostMapping("/add")
	public void add(@RequestBody() CreateOrderRequest createOrderRequest) {
		this.orderService.add(createOrderRequest);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.orderService.delete(id);
	}
	@PutMapping("/update")
	public void update(int id,CreateOrderRequest createOrderRequest) {
		this.orderService.update(id, createOrderRequest);
	}
	@GetMapping("/getbyid")
	public Order getOrderById(int id) {
		return this.orderService.getOrderById(id);
	}
		
	@GetMapping("/getbyordernumber")
	public List<Order> getByOrderNumber(String orderNumber) {
		return orderService.findByOrderNumber(orderNumber);
	}
	@GetMapping("/getbyorderstatus")
	public List<Order> getByOrderStatus(int status){
		return orderService.findByStatus(status);
	}
	@GetMapping("/getbyorderstatusanduserid")
	public List<Order> findByUserAndStatus(int userId,int status){
		return orderService.findByUserAndStatus(userId,status);
	}
}
