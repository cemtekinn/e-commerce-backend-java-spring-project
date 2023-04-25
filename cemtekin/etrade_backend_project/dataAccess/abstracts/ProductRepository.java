package cemtekin.etrade_backend_project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cemtekin.etrade_backend_project.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	Product getByProductName(String productName); 
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartsWith(String productName);
	
	//Database Queries
	@Query("FROM Product WHERE unitPrice BETWEEN :startPrice AND :endPrice")
	List<Product> getByUnitPriceBetweenRange(double startPrice,double endPrice);
}
