package cemtekin.etrade_backend_project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import cemtekin.etrade_backend_project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
	User getByUserMail(String mail);
}
