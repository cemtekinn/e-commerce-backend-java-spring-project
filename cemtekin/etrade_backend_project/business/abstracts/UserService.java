package cemtekin.etrade_backend_project.business.abstracts;

import java.util.List;

import cemtekin.etrade_backend_project.business.requests.CreateUserRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllUsersResponse;
import cemtekin.etrade_backend_project.entities.User;

public interface UserService {
	List<GetAllUsersResponse> getAll();
	User getUserById(int id);
	void add(CreateUserRequest createUserRequest);
	void delete(int id);
	void update(int id,CreateUserRequest createUserRequest);
	User getByUserMail(String mail);
}
