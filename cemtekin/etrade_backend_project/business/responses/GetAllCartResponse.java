package cemtekin.etrade_backend_project.business.responses;

import cemtekin.etrade_backend_project.entities.Product;
import cemtekin.etrade_backend_project.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCartResponse {
	private int cartID;
	private Product product;
	private User user;
	private int quantity;
}
