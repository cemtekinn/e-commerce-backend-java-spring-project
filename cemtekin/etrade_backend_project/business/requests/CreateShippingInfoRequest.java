package cemtekin.etrade_backend_project.business.requests;

import cemtekin.etrade_backend_project.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateShippingInfoRequest {
	private String name;
	private String lastName;
	private String adress;
	private String province;
	private String district;
	private String postcode;
	private String email;
	private String phoneNumber;
	private String orderNote;
	private String orderNumber;
	private User user;
}
