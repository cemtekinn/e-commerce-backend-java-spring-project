package cemtekin.etrade_backend_project.business.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllUsersResponse {
	private int userId;
	private String name;
	private String lastName;
	private String userMail;
	private Date userBirthDay;
	private String password;
	private Date registerDate;
	private String address;
	private String province;
	private String district;
	private String phoneNumber;
	private String profilePictureUrl;
	private String postCode;
	private int authority;
	
}
