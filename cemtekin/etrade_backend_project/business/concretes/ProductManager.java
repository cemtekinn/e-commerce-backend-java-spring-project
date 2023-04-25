package cemtekin.etrade_backend_project.business.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cemtekin.etrade_backend_project.business.abstracts.ProductService;
import cemtekin.etrade_backend_project.business.requests.CreateProductRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllProductsResponse;
import cemtekin.etrade_backend_project.dataAccess.abstracts.ProductRepository;
import cemtekin.etrade_backend_project.entities.Product;
@Service
public class ProductManager implements ProductService{
	private ProductRepository productRepository;
	@Autowired
	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository=productRepository;
	}
	@Override
	public List<GetAllProductsResponse> getAll() {
		//Business Rules
		List<Product> products=productRepository.findAll();
		List<GetAllProductsResponse> productsResponse=new ArrayList<GetAllProductsResponse>();
		for (Product product:products) {
			if(product !=null) {
				GetAllProductsResponse responseItem=new GetAllProductsResponse();
				responseItem.setId(product.getId());
				responseItem.setProductName(product.getProductName());
				responseItem.setDescription(product.getDescription());
				responseItem.setUnitPrice(product.getUnitPrice());
				responseItem.setUnitsInStock(product.getUnitsInStock());
				responseItem.setCategory(product.getCategory());
				responseItem.setStatus(product.getStatus());
				responseItem.setColor(product.getColor());
				responseItem.setDiscount(product.getDiscount());
				responseItem.setImage(product.getImage());
				productsResponse.add(responseItem);
			}
		}
		return productsResponse;
	}
	@Override
	public List<Product> getAll(int pageNo,int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return this.productRepository.findAll(pageable).getContent();
	}
	@Override
	public Product getProductById(int id) {
		Product product=productRepository.findById(id).get();
		return product;
	}
	@Override
	public void add(CreateProductRequest createProductRequest) {

		Product product=new Product();
		product.setProductName(createProductRequest.getProductName());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		product.setDescription(createProductRequest.getDescription());
		product.setUnitsInStock(createProductRequest.getUnitsInStock());
		product.setCategory(createProductRequest.getCategoryId());
		product.setStatus(createProductRequest.getStatus());
		product.setColor(createProductRequest.getColor());
		product.setDiscount(createProductRequest.getDiscount());
		product.setImage(createProductRequest.getImage());
		this.productRepository.save(product);
	}
	
	@Override
	public void delete(int id) {
		productRepository.deleteById(id);		
	}
	
	@Override
	public void update(int id,CreateProductRequest createProductRequest) {
		Product product=getProductById(id);
		product.setProductName(createProductRequest.getProductName());
		product.setDescription(createProductRequest.getDescription());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		product.setUnitsInStock(createProductRequest.getUnitsInStock());
		product.setCategory(createProductRequest.getCategoryId());
		product.setStatus(createProductRequest.getStatus());
		product.setColor(createProductRequest.getColor());
		product.setDiscount(createProductRequest.getDiscount());
		product.setImage(createProductRequest.getImage());
		this.productRepository.save(product);
	}
	
	
	@Override
	public Product getByProductName(String productName) {
		return productRepository.getByProductName(productName) ;
	}
	@Override
	public Product getByProductNameAndCategoryId(String productName, int categoryId) {
		return productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}
	@Override
	public List<Product> getByProductNameOrCategory(String productName, int categoryId) {
		return productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	@Override
	public List<Product> getByProductNameContains(String productName) {
		return productRepository.getByProductNameContains(productName);
	}
	@Override
	public List<Product> getByProductNameStartsWith(String productName) {
		return productRepository.getByProductNameStartsWith(productName);
	} 
	@Override
	public List<Product> getAllSortedDesc(String field){
		Sort sort=Sort.by(Sort.Direction.DESC,field);
		return productRepository.findAll(sort);
	}
	@Override
	public List<Product> getAllSortedAsc(String field){
		Sort sort=Sort.by(Sort.Direction.ASC,field);
		return productRepository.findAll(sort);
	}
	@Override
	public List<Product> getByUnitPriceBetweenRange(double startPrice,double endPrice){
		return productRepository.getByUnitPriceBetweenRange(startPrice,endPrice);
	}
	
	
}
