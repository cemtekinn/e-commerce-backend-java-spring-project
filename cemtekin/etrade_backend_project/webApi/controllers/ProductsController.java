package cemtekin.etrade_backend_project.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cemtekin.etrade_backend_project.business.abstracts.ProductService;
import cemtekin.etrade_backend_project.business.requests.CreateProductRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllProductsResponse;
import cemtekin.etrade_backend_project.entities.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	private ProductService productService;
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService=productService;
	}
	@GetMapping("/getall")
	public List<GetAllProductsResponse> getAll(){
		return productService.getAll();
	}
	@GetMapping("/getbyid")
	public Product getProductById(int id) {
		return productService.getProductById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody() CreateProductRequest createProductRequest) {
		this.productService.add(createProductRequest);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.productService.delete(id);
	}
	@PutMapping("/update")
	public void update(int id,CreateProductRequest createProductRequest) {
		this.productService.update(id, createProductRequest);
	}
	@GetMapping("/getByProductName")
	public Product getByProductName(String productName) {
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategoryId")
	public  Product getByProductNameAndCategory(String productName,int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	@GetMapping("/getAllSortedDesc")
	public List<Product> getAllSortedDesc(String field){
		return this.productService.getAllSortedDesc(field);
	}
	@GetMapping("/getAllSortedAsc")
	public List<Product> getAllSortedAsc(String field){
		return this.productService.getAllSortedAsc(field);
	}
	@GetMapping("/getByProductNameContains")
	public List<Product> getByProductNameContains(String productName) {
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getAllByPage")
	public List<Product> getAll(int pageNo,int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	@GetMapping("/getByUnitPriceBetweenRange")
	public List<Product> getByUnitPriceBetweenRange(double startPrice,double endPrice){
		return this.productService.getByUnitPriceBetweenRange(startPrice, endPrice);
	}
}
