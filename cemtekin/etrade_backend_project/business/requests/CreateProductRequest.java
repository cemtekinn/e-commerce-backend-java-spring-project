package cemtekin.etrade_backend_project.business.requests;

import cemtekin.etrade_backend_project.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	private String productName;
	private Category categoryId;
	private int unitsInStock;
	private String description;
	private double unitPrice;
	private double discount;
	private int status;
	private String color;
	private String image;
}

