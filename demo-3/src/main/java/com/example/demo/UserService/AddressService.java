package com.example.demo.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Bean.AddressInfo;
import com.example.demo.vo.AddressResult;
import com.example.demo.vo.addAddressResult;
import com.example.demo.vo.registerResult;

@Service
public interface AddressService {



	List<AddressResult> search(AddressInfo addressInfo);

	List<registerResult> getRegisterName();

	void add(addAddressResult addAddressResult);
	

}
