package cemtekin.etrade_backend_project.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int userId;
	@Column(name="name")
	private String name;
	@Column(name="user_mail")
	@Email
	@NotBlank
	@NotNull
	private String userMail;
	@Column (name="user_birthday")
	private Date userBirthday;
	@Column (name="password")
	@NotBlank
	@NotNull
	private String password;
	@Column(name="lastname")
	private String lastName;
	@Column(name="register_date")
	private Date registerDate;
	@Column(name="user_address")
	private String address;
	@Column(name="province")
	private String province;
	@Column(name="district")
	private String district;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="profile_picture")
	private String profilePictureUrl;
	@Column(name="post_code")
	private String postCode;
	//İf 'authority' =1 ->user, 2 ->admin
	@Column(name="authority")
	private int authority;
	
	/*
	@OneToMany(mappedBy="user")
	private List<User> users;
	*/
}
