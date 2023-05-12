package cemtekin.etrade_backend_project.business.abstracts;

import java.util.List;


import cemtekin.etrade_backend_project.business.requests.CreateOrderRequest;
import cemtekin.etrade_backend_project.entities.Order;

public interface OrderService {
	Order getOrderById(int id);
	void add(CreateOrderRequest createOrderRequest);
	void delete(int id);
	void update(int id,CreateOrderRequest createOrderRequest);
	List<Order> findByOrderNumber(String orderNumber);
	List<Order> findByStatus(int status);
	List<Order> findByUserAndStatus(int userId,int status);
}
