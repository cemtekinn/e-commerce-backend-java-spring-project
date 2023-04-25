package cemtekin.etrade_backend_project.business.responses;

import cemtekin.etrade_backend_project.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
	private int id;
	private Category category;
	private String productName;
	private int unitsInStock;
	private String description;
	private double unitPrice;
	private double discount;
	private int status;
	private String color;
	private String image;
}
