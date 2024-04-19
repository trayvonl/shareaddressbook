package com.example.demo.UserMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Bean.AddAddress;
import com.example.demo.Bean.AddressInfo;
import com.example.demo.Bean.DeleteAddress;
import com.example.demo.vo.AddressResult;

@Mapper
public interface AddressMapper {

//	List<AddressResult> search(AddressInfo addressInfo);

	void add(AddAddress addAddress);

	List<AddressResult> getAll();

	void deleteAb(DeleteAddress deleteAddress);

	List<AddressResult> search(AddressInfo addressInfo);


}
