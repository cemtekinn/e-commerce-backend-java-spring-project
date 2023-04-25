package cemtekin.etrade_backend_project.business.abstracts;

import java.util.List;

import cemtekin.etrade_backend_project.business.requests.CreateCartRequest;
import cemtekin.etrade_backend_project.entities.Cart;
import cemtekin.etrade_backend_project.entities.User;

public interface CartService {
	
	Cart getCartById(int id);
	void add(CreateCartRequest createCartRequest);
	void delete(int id);
	void update(int id,CreateCartRequest createCartRequest);
	List<Cart> findByUser(User user);
}
