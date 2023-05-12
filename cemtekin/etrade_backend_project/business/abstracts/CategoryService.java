package cemtekin.etrade_backend_project.business.abstracts;

import java.util.List;
import cemtekin.etrade_backend_project.business.requests.CreateCategoryRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllCategoriesResponse;
import cemtekin.etrade_backend_project.entities.Category;


public interface CategoryService {
	List<GetAllCategoriesResponse> getAll();
	Category getCategoryById(int id);
	void add(CreateCategoryRequest createCategoryRequest);
	void delete(int id);
	void update(int id,CreateCategoryRequest createCategoryRequest);
	
}
