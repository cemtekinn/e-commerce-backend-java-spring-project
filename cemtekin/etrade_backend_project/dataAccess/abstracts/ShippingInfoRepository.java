package cemtekin.etrade_backend_project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cemtekin.etrade_backend_project.entities.ShippingInfo;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo,Integer>{
	List<ShippingInfo> findByOrderNumber(String orderNumber);
	
}
