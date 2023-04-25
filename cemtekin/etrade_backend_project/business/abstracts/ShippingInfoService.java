package cemtekin.etrade_backend_project.business.abstracts;

import java.util.List;

import cemtekin.etrade_backend_project.business.requests.CreateShippingInfoRequest;
import cemtekin.etrade_backend_project.entities.ShippingInfo;

public interface ShippingInfoService {
	ShippingInfo getShippingInfoById(int id);
	void add(CreateShippingInfoRequest createShippingInfoRequest);
	void delete(int id);	
	List<ShippingInfo> findByOrderNumber(String orderNumber);
	
}
