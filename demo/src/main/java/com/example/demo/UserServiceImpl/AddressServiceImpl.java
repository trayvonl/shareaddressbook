package com.example.demo.UserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressId;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.UserMapper.AddressMapper;
import com.example.demo.UserService.AddressService;
import com.example.demo.vo.AddressResult;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	/**
	 * ユーザーが入力した情報を検索し、リストを返します
	 * 
	 * @param addressInfo ユーザー入力情報オブジェクト
	 */
//	@Override
//	public List<AddressResult> search(AddressInfo addressInfo) {
//		List<AddressResult> list = addressMapper.search(addressInfo);
//		return list;
//	}
	/**
	 * 新しいアドレス情報を追加します
	 * 
	 * @param addAddress
	 */
	@Override
	public void add(AddAddress addAddress) {
		// TODO Auto-generated method stub
		Date creatDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		dateFormat.format(creatDate);
		addAddress.setCreatDate(creatDate);
		addressMapper.add(addAddress);

	}

	/**
	 * すべてのアドレス情報を返す
	 * 
	 * @param null
	 */
	@Override
	public List<AddressResult> getAll() {
		// TODO Auto-generated method stub
		List<AddressResult> list = addressMapper.getAll();
		return list;
	}

	/**
	 * ユーザーを削除する
	 * 
	 * @param addressId
	 */
	@Override
	public void deleteAb(AddressId addressId) {
		// TODO Auto-generated method stub
		addressMapper.deleteAb(addressId);

	}

	/**
	 * 検索機能
	 * 
	 * @param addressInfo
	 */
	@Override
	public List<AddressResult> search(AddressInfo addressInfo) {
		// TODO Auto-generated method stub
		List<AddressResult> list = addressMapper.search(addressInfo);
		return list;
	}
	/**
	 * IDに基づいて単一のユーザー情報を返す
	 * 
	 * @param addressId
	 */
	@Override
	public AddressResult getAddress(AddressId addressId) {
		// TODO Auto-generated method stub
		AddressResult addressResult = addressMapper.getAddress(addressId);
		return addressResult;
	}
	/**
	 * ユーザー情報を更新する
	 * 
	 * @param addAddress
	 */
	@Override	
	public void updateAddress(AddAddress addAddress) {
		// TODO Auto-generated method stub
		Date creatDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		dateFormat.format(creatDate);
		addAddress.setCreatDate(creatDate);
		addressMapper.updateAddress(addAddress);
	}

}
