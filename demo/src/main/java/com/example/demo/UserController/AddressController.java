package com.example.demo.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.Bean.DeleteAddress;
import com.example.demo.UserService.AddressService;
import com.example.demo.vo.AddressResult;

@Controller
@CrossOrigin
public class AddressController {

	@Autowired
	private AddressService addressService;
	@RequestMapping("/getAllAddress")
	public String getAll(Model model) {
		List<AddressResult> list=addressService.getAll();
		model.addAttribute("list",list);
		return "shareaddressbook::ablist1";
	}
//	@RequestMapping("/searchAddress")
//	public String search(@RequestBody AddressInfo addressInfo, Model model) {
//		List<AddressResult> list = addressService.search(addressInfo);
//		model.addAttribute("list",list);
//		System.out.println(addressInfo);
//		System.out.println(list);
//		return "shareaddressbook::ablist1";
//	}
	@RequestMapping("/searchAddress")
	public String search(@RequestBody AddressInfo addressInfo,Model model) {
		List<AddressResult> list=addressService.search(addressInfo);
		model.addAttribute("list",list);
		return "shareaddressbook::ablist1";
	}
	//添加用户
	@RequestMapping("/addNew")
	public String add(AddAddress addAddress,Model model) {
		System.out.println(addAddress);
		return "shareaddressbook";//添加成功，回到shareaddressbook页面
		
	}
	@RequestMapping("/delete")
	public String deleteAb(DeleteAddress deleteAddress,Model model) {
		addressService.deleteAb(deleteAddress);
		System.out.println(deleteAddress);
		return "shareaddressbook";
		
	}
}
