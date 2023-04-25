package cemtekin.etrade_backend_project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
@Entity
public class Category {
	@Id
	@Column(name="category_id")
	private int categoryId;
	@Column(name="category_name")
	private String categoryName;
	@Column(name="description")
	private String description;
	@Column(name="image")
	private String image;
	
	
	 // @OneToMany(mappedBy="category")
	 // private List<Product> products;
	
}

