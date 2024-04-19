package com.example.demo.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.Bean.DeleteAddress;
import com.example.demo.vo.AddressResult;

@Service
public interface AddressService {
	/**
	*ユーザーが入力した情報を検索し、リストを返します
	*@param addressInfo ユーザー入力情報オブジェクト
	*/
//	List<AddressResult> search(AddressInfo addressInfo);
	/**
	*新しいアドレス情報を追加します
	*@param addAddress
	*/
	void add(AddAddress addAddress);
	/**
	*查询返回所有通讯录信息
	*@param null
	*/
	List<AddressResult> getAll();
	void deleteAb(DeleteAddress deleteAddress);
	List<AddressResult> search(AddressInfo addressInfo);

}
