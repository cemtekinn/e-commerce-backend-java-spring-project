package cemtekin.etrade_backend_project.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cemtekin.etrade_backend_project.business.abstracts.CategoryService;
import cemtekin.etrade_backend_project.business.requests.CreateCategoryRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllCategoriesResponse;
import cemtekin.etrade_backend_project.entities.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	private CategoryService categoryService;
	@Autowired
	public CategoriesController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@GetMapping("/getall")
	public List<GetAllCategoriesResponse> getAll(){
		return categoryService.getAll();
	}
	@GetMapping("/getbyid")
	public Category getById(int id) {
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateCategoryRequest createCategoryRequest) {
		this.categoryService.add(createCategoryRequest);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.categoryService.delete(id);
	}
	@PutMapping("/update")
	public void update( int id,CreateCategoryRequest createCategoryRequest) {
		this.categoryService.update(id, createCategoryRequest);
	}
}
