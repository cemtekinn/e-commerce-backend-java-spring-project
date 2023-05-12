package cemtekin.etrade_backend_project.entities;



import java.util.Date;

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

@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@Column(name="product_name")
	private String productName;
	@Column(name="quantity")
	private int quantity;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="discount")
	private double discount;
	@Column(name="total_price")
	private double totalPrice;
	@Column(name="order_number")
	private String orderNumber;
	@Column(name="status")
	private int status;
	@Column(name="order_time")
	private Date orderTime;

	/*
	@ManyToOne
	@JoinColumn(name="shipping_id")
	private ShippingInfo shippingInfo;

	*/
}
