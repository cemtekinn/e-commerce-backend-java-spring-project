package cemtekin.etrade_backend_project.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cemtekin.etrade_backend_project.business.abstracts.CategoryService;
import cemtekin.etrade_backend_project.business.requests.CreateCategoryRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllCategoriesResponse;
import cemtekin.etrade_backend_project.dataAccess.abstracts.CategoryRepository;
import cemtekin.etrade_backend_project.entities.Category;
@Service
public class CategoryManager implements CategoryService{
	private CategoryRepository categoryRepository;
	@Autowired
	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository=categoryRepository;
	}
		
	@Override
	public List<GetAllCategoriesResponse> getAll() {
		//Business Rules
		List<Category> categories=categoryRepository.findAll();
		List<GetAllCategoriesResponse> categoryResponse=new ArrayList<GetAllCategoriesResponse>();
		for (Category category : categories) {
			GetAllCategoriesResponse responseItem=new GetAllCategoriesResponse();
			responseItem.setCategoryId(category.getCategoryId());
			responseItem.setCategoryName(category.getCategoryName());
			responseItem.setDescription(category.getDescription());
			responseItem.setImage(category.getImage());
			categoryResponse.add(responseItem);
		}
		return categoryResponse;
	}
	
	@Override
	public Category getCategoryById(int id) {
		Category category=categoryRepository.findById(id);
		return category;
	}
	
	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		Category category=new Category();
		category.setCategoryName(createCategoryRequest.getCategoryName());
		category.setDescription(createCategoryRequest.getDescription());
		category.setImage(createCategoryRequest.getImage());
		this.categoryRepository.save(category);
	}
	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}
	
	@Override
	public void update(int id ,CreateCategoryRequest createCategoryRequest) {
		Category category= getCategoryById(id);		
		category.setCategoryName(createCategoryRequest.getCategoryName());
		category.setDescription(createCategoryRequest.getDescription());
		category.setImage(createCategoryRequest.getImage());
		this.categoryRepository.save(category);	
	}
	
}
