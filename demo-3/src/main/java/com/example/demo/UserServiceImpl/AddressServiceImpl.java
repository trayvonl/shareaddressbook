package com.example.demo.UserServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.AddressInfo;
import com.example.demo.UserMapper.AddressMapper;
import com.example.demo.UserService.AddressService;
import com.example.demo.vo.AddressResult;
import com.example.demo.vo.addAddressResult;
import com.example.demo.vo.registerResult;

import java.time.LocalDate;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public List<AddressResult> search(AddressInfo addressInfo) {
		List<AddressResult> list = addressMapper.search(addressInfo);
    	return list;
	}

	@Override
	public List<registerResult> getRegisterName() {
		List<registerResult> list2=addressMapper.getRegisterName();
		return list2;
	}

	@Override
	public void add(addAddressResult addAddressResult) {
		// TODO Auto-generated method stub
		LocalDate nowTime=LocalDate.now();
		addAddressResult.setCreateDate(nowTime);
		addressMapper.add(addAddressResult);
	};
}