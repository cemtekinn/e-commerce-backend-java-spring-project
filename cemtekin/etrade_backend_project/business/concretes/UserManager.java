package cemtekin.etrade_backend_project.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cemtekin.etrade_backend_project.business.abstracts.UserService;
import cemtekin.etrade_backend_project.business.requests.CreateUserRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllUsersResponse;
import cemtekin.etrade_backend_project.dataAccess.abstracts.UserRepository;
import cemtekin.etrade_backend_project.entities.User;

@Service
public class UserManager implements UserService {
	private UserRepository userRepository;
	@Autowired
	public UserManager(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}
	@Override
	public List<GetAllUsersResponse> getAll() {
		List<User> users=userRepository.findAll();
		
			List<GetAllUsersResponse> userResponse=new ArrayList<GetAllUsersResponse>();
				for (User user: users) {
					if(user !=null) {
						GetAllUsersResponse responseItem=new GetAllUsersResponse();
						responseItem.setUserId(user.getUserId());
						responseItem.setName(user.getName());
						responseItem.setLastName(user.getLastName());
						responseItem.setUserMail(user.getUserMail());
						responseItem.setUserBirthDay(user.getUserBirthday());
						responseItem.setPassword(user.getPassword());
						responseItem.setRegisterDate(user.getRegisterDate());
						responseItem.setAddress(user.getAddress());
						responseItem.setProfilePictureUrl(user.getProfilePictureUrl());
						responseItem.setProvince(user.getProvince());
						responseItem.setDistrict(user.getDistrict());
						responseItem.setPhoneNumber(user.getPhoneNumber());
						responseItem.setPostCode(user.getPostCode());
						responseItem.setAuthority(user.getAuthority());
						userResponse.add(responseItem);
						}
					}
				return userResponse;
		
			
	}
	@Override
	public User getUserById(int id) {
		User user=userRepository.findById(id).get();
		return user;
	}
	
	@Override
	public void add(CreateUserRequest createUserRequest) {
		User user=new User();
		user.setName(createUserRequest.getName());
		user.setLastName(createUserRequest.getLastName());
		user.setUserMail(createUserRequest.getUserMail());
		user.setUserBirthday(createUserRequest.getUserBirthDay());
		user.setPassword(createUserRequest.getPassword());
		user.setRegisterDate(createUserRequest.getRegisterDate());
		user.setAddress(createUserRequest.getAddress());
		user.setProvince(createUserRequest.getProvince());
		user.setDistrict(createUserRequest.getDistrict());
		user.setPhoneNumber(createUserRequest.getPhoneNumber());
		user.setProfilePictureUrl(createUserRequest.getProfilePictureUrl());
		user.setPostCode(createUserRequest.getPostCode());
		user.setAuthority(createUserRequest.getAuthority());
		this.userRepository.save(user);	
	}
	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	@Override
	public void update(int id, CreateUserRequest createUserRequest) {
		User user=getUserById(id);
		user.setName(createUserRequest.getName());
		user.setLastName(createUserRequest.getLastName());
		user.setUserMail(createUserRequest.getUserMail());
		user.setUserBirthday(createUserRequest.getUserBirthDay());
		user.setPassword(createUserRequest.getPassword());
		user.setRegisterDate(createUserRequest.getRegisterDate());
		user.setAddress(createUserRequest.getAddress());
		user.setProvince(createUserRequest.getProvince());
		user.setDistrict(createUserRequest.getDistrict());
		user.setPhoneNumber(createUserRequest.getPhoneNumber());
		user.setProfilePictureUrl(createUserRequest.getProfilePictureUrl());
		user.setPostCode(createUserRequest.getPostCode());
		user.setAuthority(createUserRequest.getAuthority());
		this.userRepository.save(user);
	}
	@Override
	public User  getByUserMail(String mail) {
		return userRepository.getByUserMail(mail);
	}
}
