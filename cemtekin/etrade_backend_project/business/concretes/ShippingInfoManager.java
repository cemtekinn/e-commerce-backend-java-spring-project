package cemtekin.etrade_backend_project.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import cemtekin.etrade_backend_project.business.abstracts.ShippingInfoService;
import cemtekin.etrade_backend_project.business.requests.CreateShippingInfoRequest;
import cemtekin.etrade_backend_project.dataAccess.abstracts.ShippingInfoRepository;
import cemtekin.etrade_backend_project.entities.ShippingInfo;

@Service
public class ShippingInfoManager implements ShippingInfoService {
	private ShippingInfoRepository shippingInfoRepository;
	
	public ShippingInfoManager(ShippingInfoRepository shippingInfoRepository) {
		this.shippingInfoRepository=shippingInfoRepository;
	}
	
	@Override
	public ShippingInfo getShippingInfoById(int id) {
		return this.shippingInfoRepository.findById(id).get();
	}

	@Override
	public void add(CreateShippingInfoRequest createShippingInfoRequest) {
		ShippingInfo shippingInfo=new ShippingInfo();
		shippingInfo.setAdress(createShippingInfoRequest.getAdress());
		shippingInfo.setDistrict(createShippingInfoRequest.getDistrict());
		shippingInfo.setEmail(createShippingInfoRequest.getEmail());
		shippingInfo.setLastName(createShippingInfoRequest.getLastName());
		shippingInfo.setName(createShippingInfoRequest.getName());
		shippingInfo.setOrderNote(createShippingInfoRequest.getOrderNote());
		shippingInfo.setOrderNumber(createShippingInfoRequest.getOrderNumber());
		shippingInfo.setPhoneNumber(createShippingInfoRequest.getPhoneNumber());
		shippingInfo.setPostCode(createShippingInfoRequest.getPostcode());
		shippingInfo.setProvince(createShippingInfoRequest.getProvince());
		shippingInfo.setUser(createShippingInfoRequest.getUser());
		this.shippingInfoRepository.save(shippingInfo);
		
	}

	@Override
	public void delete(int id) {
		this.shippingInfoRepository.deleteById(id);
		
	}



	@Override
	public List<ShippingInfo> findByOrderNumber(String orderNumber) {
		
		return this.shippingInfoRepository.findByOrderNumber(orderNumber);
	}
	

}
