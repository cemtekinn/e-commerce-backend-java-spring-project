package cemtekin.etrade_backend_project.business.responses;

import cemtekin.etrade_backend_project.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetAllShippingInfosResponse {
	private int id;
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
