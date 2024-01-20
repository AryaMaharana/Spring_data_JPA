package com.example.demo.service;

import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.GetUserResponse;

public interface DemoService {

	public GetUserResponse getUserInfo(Integer id);
	public GetUserResponse getProductInfo(Integer id);

	public void createUser(CreateUserRequest createUserRequest);
	/*
	 * public void udateStudentInfo(Student info); public void
	 * deleteStudentInfo(Integer id);
	 */

}
