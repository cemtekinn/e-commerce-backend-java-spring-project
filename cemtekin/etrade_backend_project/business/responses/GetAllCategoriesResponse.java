package cemtekin.etrade_backend_project.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoriesResponse {
	private int categoryId;
	private String categoryName;
	private String description;
	private String image;
}
