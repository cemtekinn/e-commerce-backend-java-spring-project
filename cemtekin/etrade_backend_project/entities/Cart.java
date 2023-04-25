package cemtekin.etrade_backend_project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="products_in_the_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int cartID;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
		
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	
	@Column(name="quantity")
	private int quantity;
	
	
}
