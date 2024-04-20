package com.example.demo.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressId;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.vo.AddressResult;

@Service
public interface AddressService {
	/**
	 * 新しいアドレス情報を追加します
	 * 
	 * @param addAddress
	 */
	void add(AddAddress addAddress);

	/**
	 * すべてのアドレス情報を返す
	 * 
	 * @param null
	 */
	List<AddressResult> getAll();

	/**
	 * ユーザーを削除する
	 * 
	 * @param addressId
	 */
	void deleteAb(AddressId addressId);

	/**
	 * 検索機能
	 * 
	 * @param addressInfo
	 */
	List<AddressResult> search(AddressInfo addressInfo);

	/**
	 * IDに基づいて単一のユーザー情報を返す
	 * 
	 * @param addressId
	 */
	AddressResult getAddress(AddressId addressId);
	/**
	 * ユーザー情報を更新する
	 * 
	 * @param addAddress
	 */
	void updateAddress(AddAddress addAddress);

}
