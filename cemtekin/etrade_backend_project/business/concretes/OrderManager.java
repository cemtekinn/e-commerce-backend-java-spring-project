package cemtekin.etrade_backend_project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Utils.RandomNumberGenerator;
import cemtekin.etrade_backend_project.business.abstracts.OrderService;
import cemtekin.etrade_backend_project.business.requests.CreateOrderRequest;
import cemtekin.etrade_backend_project.dataAccess.abstracts.OrderRepository;
import cemtekin.etrade_backend_project.entities.Order;
@Service
public class OrderManager implements OrderService {

	private OrderRepository orderRepository; 
	
	@Autowired
	public OrderManager(OrderRepository orderRepository) {
		super();
		this.orderRepository=orderRepository;
	}
	
	@Override
	public Order getOrderById(int id) {
		Order order=orderRepository.findById(id).get();
		return order;
	}

	@Override
	public void add(CreateOrderRequest createOrderRequest) {
		Order order=new Order();
		int randomNum=RandomNumberGenerator.randomNumber(8);
		
		order.setOrderNumber(Integer.toString(randomNum));
		order.setDiscount(createOrderRequest.getDiscount());
		order.setOrderNumber(createOrderRequest.getOrderNumber());
		order.setProduct(createOrderRequest.getProduct());
		order.setProductName(createOrderRequest.getProductName());
		order.setQuantity(createOrderRequest.getQuantity());
		//order.setShippingInfo(createOrderRequest.getShippingInfo());
		order.setTotalPrice(createOrderRequest.getTotalPrice());
		order.setUnitPrice(createOrderRequest.getUnitPrice());
		order.setStatus(createOrderRequest.getStatus());
		order.setUser(createOrderRequest.getUser());
		this.orderRepository.save(order);
	}
	
	@Override
	public void update(int id, CreateOrderRequest createOrderRequest) {
		Order order=getOrderById(id);
		order.setStatus(createOrderRequest.getStatus());
		this.orderRepository.save(order);
	}

	@Override
	public void delete(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public List<Order> findByOrderNumber(String orderNumber) {
		return orderRepository.findByOrderNumber(orderNumber);
	}

	@Override
	public List<Order> findByStatus(int status) {
		return orderRepository.findByStatus(status);
	}

	@Override
	public List<Order> findByUserAndStatus(int userId,int status) {
		return orderRepository.findByUserAndStatus(userId, status);
	}

}
