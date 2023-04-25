package cemtekin.etrade_backend_project.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cemtekin.etrade_backend_project.business.abstracts.ShippingInfoService;
import cemtekin.etrade_backend_project.business.requests.CreateShippingInfoRequest;
import cemtekin.etrade_backend_project.entities.ShippingInfo;

@RestController
@RequestMapping("api/shippinginfos")
public class ShippingInfosController {
	private ShippingInfoService shippingInfoService;
	public ShippingInfosController(ShippingInfoService shippingInfoService) {
		this.shippingInfoService=shippingInfoService;
	}
	@PostMapping("/add")
	public void add(@RequestBody() CreateShippingInfoRequest createShippingInfoRequest) {
		this.shippingInfoService.add(createShippingInfoRequest);
	}
	@GetMapping("/getbyid")
	public ShippingInfo getShippingInfo(int id) {
		return this.shippingInfoService.getShippingInfoById(id);
	}
	@GetMapping("/getbyordernumber")
	public List<ShippingInfo> getByOrderNumber(String orderNumber) {
		return shippingInfoService.findByOrderNumber(orderNumber);
	}
}
