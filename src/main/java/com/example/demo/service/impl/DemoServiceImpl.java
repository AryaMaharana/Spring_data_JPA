package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.mapping.UserMapper;
import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.GetUserResponse;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public void createUser(CreateUserRequest createUserRequest) {
		if (Objects.nonNull(createUserRequest)) {
			userRepo.save(UserMapper.createUserMapping(createUserRequest));
		}
	}

	@Cacheable(value = "user")
	@Override
	public GetUserResponse getUserInfo(Integer id) {
		GetUserResponse response = new GetUserResponse();
		List<User> userList = new ArrayList<>();
		Optional<User> getUser = userRepo.findById(id);
		if(getUser.isPresent()) {
			userList.add(getUser.get());
		}
		response.setUser(userList);
		return response;
	}

	@Override
	public GetUserResponse getProductInfo(Integer id) {
		GetUserResponse response = new GetUserResponse();
		List<Product> getproductList = new ArrayList<>();
		Optional<Product> getProduct = productRepo.findById(id);
		if(getProduct.isPresent()) {
			getproductList.add(getProduct.get());
		}
		response.setProduct(getproductList);
		return response;
	}

}
