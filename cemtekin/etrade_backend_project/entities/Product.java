package cemtekin.etrade_backend_project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","categories"})
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	@Column(name="product_name")
	private String productName;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="description")
	private String description;
	@Column(name="stock_amount")
	private int unitsInStock;
	@Column(name="image")
	private String image;
	@Column(name="discount")
	private double discount;
	@Column(name="status")
	private int status;
	@Column(name="color")
	private String color;
		
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;

	
	
}

