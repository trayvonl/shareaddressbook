package com.example.demo.UserServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.Bean.DeleteAddress;
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
	*新しいアドレス情報を追加します
	*@param addAddress
	*/
	@Override
	public void add(AddAddress addAddress) {
		// TODO Auto-generated method stub
		Date creatDate = new Date();
		addAddress.setCreatDate(creatDate);
		addressMapper.add(addAddress);
		
	}

	@Override
	public List<AddressResult> getAll() {
		// TODO Auto-generated method stub
		List<AddressResult> list=addressMapper.getAll();
		return list;
	}
	@Override
	public void deleteAb(DeleteAddress deleteAddress) {
		// TODO Auto-generated method stub
		addressMapper.deleteAb(deleteAddress);
		
	}

	@Override
	public List<AddressResult> search(AddressInfo addressInfo) {
		// TODO Auto-generated method stub
		List<AddressResult> list=addressMapper.search(addressInfo);
		return list;
	}

}
