package cemtekin.etrade_backend_project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cemtekin.etrade_backend_project.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	 List<Order> findByOrderNumber(String orderNumber);
	 List<Order> findByStatus(int status);
	 List<Order> findOrderByUser(int userid);
	 List<Order> findByUserAndStatus(int userId,int status);
}
