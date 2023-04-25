package cemtekin.etrade_backend_project.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cemtekin.etrade_backend_project.business.abstracts.UserService;
import cemtekin.etrade_backend_project.business.requests.CreateUserRequest;
import cemtekin.etrade_backend_project.business.responses.GetAllUsersResponse;
import cemtekin.etrade_backend_project.entities.User;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UsersController {
	private UserService userService;
	@Autowired
	public UsersController(UserService userService) {
		this.userService=userService;
	}
	@GetMapping("/getall")
	public List<GetAllUsersResponse> getAll(){
		return userService.getAll();
	}
	@GetMapping("/getbyid")
	public User getById(int id) {
		return userService.getUserById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody() CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody() int id) {
		this.userService.delete(id);
	}
	@PutMapping("/update")
	public void update(int id,CreateUserRequest createUserRequest) {
		this.userService.update(id, createUserRequest);
	}
	@GetMapping("/getByMail")
	public User getByUserMail(String email) {
		return this.userService.getByUserMail(email);
	}
}
