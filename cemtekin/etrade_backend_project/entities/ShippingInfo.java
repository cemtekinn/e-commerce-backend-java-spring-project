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

@Table(name="shipping_infos")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ShippingInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shipping_id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="lastname")
	private String lastName;
	@Column(name="address")
	private String adress;
	@Column(name="province")
	private String province;
	@Column(name="district")
	private String district;
	@Column(name="post_code")
	private String postCode;
	@Column(name="email")
	private String email;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="order_note")
	private String orderNote;
	@Column(name="order_number")
	private String orderNumber;

	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
}
