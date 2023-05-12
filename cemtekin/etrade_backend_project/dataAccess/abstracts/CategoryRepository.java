package cemtekin.etrade_backend_project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import cemtekin.etrade_backend_project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
	Category findById(int id);
	Category findByCategoryName(String categoryName);
}
