package com.example.demo.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.model.CreateUserRequest;

public class UserMapper {
	
	public static User createUserMapping(CreateUserRequest createUserRequest) {
		User user = new User();
		List<Product> productList = new ArrayList<>();
		BeanUtils.copyProperties(createUserRequest, user);
		for(Product p: createUserRequest.getProduct()) {
			productList.add(p);
		}
		user.setProduct(productList);
		return user;
	}
}
