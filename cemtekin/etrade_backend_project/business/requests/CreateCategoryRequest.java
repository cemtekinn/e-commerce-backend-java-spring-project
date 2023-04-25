package cemtekin.etrade_backend_project.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
	private String categoryName;
	private String description;
	private String image;
}
