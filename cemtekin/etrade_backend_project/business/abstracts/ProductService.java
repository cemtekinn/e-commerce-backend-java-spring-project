package cemtekin.etrade_backend_project.business.abstracts;

import java.util.List;

import cemtekin.etrade_backend_project.business.requests.CreateProductRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllProductsResponse;
import cemtekin.etrade_backend_project.entities.Product;

public interface ProductService {
	List<GetAllProductsResponse> getAll();
	List<Product> getProductsByCategoryId(int categoryId);
	List<Product> getProductsByCategoryName(String categoryName);
	
	List<Product> getAll(int pageNo,int pageSize);
	
	Product getProductById(int id);
	
	void add(CreateProductRequest createProductRequest);
	void delete(int id);
	void update(int id,CreateProductRequest createProductRequest);
	
	Product getByProductName(String productName);
	Product getByProductNameAndCategoryId(String productName,int categoryId);
	List<Product> getByProductNameOrCategory(String productName,int categoryId);
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartsWith(String productName);
	List<Product> getAllSortedDesc(String field);
	List<Product> getAllSortedAsc(String field);
	List<Product> getByUnitPriceBetweenRange(double startPrice,double endPrice);
		
}
