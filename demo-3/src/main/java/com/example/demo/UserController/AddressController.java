package com.example.demo.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Bean.AddressInfo;
import com.example.demo.UserService.AddressService;
import com.example.demo.vo.AddressResult;
import com.example.demo.vo.addAddressResult;
import com.example.demo.vo.registerResult;

@Controller
@CrossOrigin
public class AddressController {
	@Autowired
	private AddressService addressService;
	@RequestMapping("/shareaddressbook")
	public String searchAddressBooks(@RequestBody AddressInfo addressInfo,Model model){
	    List<AddressResult> list = addressService.search(addressInfo);
	    model.addAttribute("list",list);
	    return "shareaddressbook::absList";
	}
	@RequestMapping("/getregistername")
	public String getRegisterName(Model model) {
		List<registerResult> list2=addressService.getRegisterName();
		model.addAttribute("list2",list2);
		return "shareaddressbook::getRegister";
	}
	@RequestMapping("/addAddress")
	public String addAddressInfo(addAddressResult addAddressResult) {
		addressService.add(addAddressResult);
		return "redirect:/shareaddressbook";
	}
}