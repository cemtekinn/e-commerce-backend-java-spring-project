package cemtekin.etrade_backend_project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cemtekin.etrade_backend_project.entities.Cart;
import cemtekin.etrade_backend_project.entities.User;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByUser(User user);
}
