package com.example.demo.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressId;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.UserService.AddressService;
import com.example.demo.vo.AddressResult;

@Controller
@CrossOrigin
public class AddressController {
	// 初期表示時にすべてのデータを表示する
	@Autowired
	private AddressService addressService;

	@RequestMapping("/getAllAddress")
	public String getAll(Model model) {
		List<AddressResult> list = addressService.getAll();
		model.addAttribute("list", list);
		return "shareaddressbook::ablist1";
	}

	// ユーザーが入力した内容に基づいて情報を検索する
	@RequestMapping("/searchAddress")
	public String search(@RequestBody AddressInfo addressInfo, Model model) {
		List<AddressResult> list = addressService.search(addressInfo);
		model.addAttribute("list", list);
		return "shareaddressbook::ablist1";

	}

	// ユーザーを追加する
	@RequestMapping("/addNew")
	public String add(AddAddress addAddress, Model model) {
		addressService.add(addAddress);
		System.out.println(addAddress);
		return "shareaddressbook";// 追加成功、shareaddressbookページに戻る

	}

	// ユーザーを削除する
	@PostMapping("/deleteAddress")
	public String deleteAb(@RequestBody AddressId addressId, Model model) {
		addressService.deleteAb(addressId);
		return "shareaddressbook";

	}

	// // IDに基づいて対応する情報を返す
	@RequestMapping("/getInfo")
	public String getAddress(AddressId addressId, Model model) {
		AddressResult addressResult = addressService.getAddress(addressId);
		model.addAttribute("addressResult", addressResult);
		return "update";

	}

	// ユーザー情報を更新する
	@RequestMapping("/updateInfo")
	public String updateAddress(AddAddress addAddress, Model model) {
		addressService.updateAddress(addAddress);
		return "redirect:/shareaddressbook";// update成功、shareaddressbookページに戻る

	}
}
