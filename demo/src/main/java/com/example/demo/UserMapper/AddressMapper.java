package com.example.demo.UserMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressId;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.vo.AddressResult;

@Mapper
public interface AddressMapper {

	void add(AddAddress addAddress);

	List<AddressResult> getAll();

	void deleteAb(AddressId addressId);

	List<AddressResult> search(AddressInfo addressInfo);

	AddressResult getAddress(AddressId addressId);

	void updateAddress(AddAddress addAddress);

}
