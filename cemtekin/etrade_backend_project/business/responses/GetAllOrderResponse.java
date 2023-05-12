package cemtekin.etrade_backend_project.business.responses;

import java.util.Date;

import cemtekin.etrade_backend_project.entities.Product;
import cemtekin.etrade_backend_project.entities.ShippingInfo;
import cemtekin.etrade_backend_project.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetAllOrderResponse {
	private int orderId;
	private Product product;
	private User user;
	private String productName;
	private int quantity;
	private double unitPrice;
	private double discount;
	private double totalPrice;
	private String orderNumber;
	private int status;
	private Date orderTime;
	private ShippingInfo shippingInfo;
}
