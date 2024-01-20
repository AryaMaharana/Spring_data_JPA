package com.example.demo.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.GetUserResponse;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.DemoService;
import com.example.demo.utils.QueryUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class DemoController {
	Logger log = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private DemoService demoService;
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping(value = "/hello/{id}")
	public String getAddress(@PathVariable("id") String name) {
		return "ID " + name;
	}

	@GetMapping(value = "/user")
	public ResponseEntity<?> getUser(@Valid @RequestParam(name = "id", required = true) Integer id)
			throws BusinessException {
		 GetUserResponse response = demoService.getUserInfo(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/specification")
	public ResponseEntity<?> getUserSpecification(
			@Valid @RequestParam(name = "firstName", required = true) String firstName,
			@Valid @RequestParam(name = "email", required = true) String email,
			@Valid @RequestParam(name = "phone", required = true) Integer phone,
			@RequestParam(name = "numberOfRow", required = false) Integer numberOfRow,
			@RequestParam(name = "pageNumber", required = false) Integer pageNumber) throws BusinessException {
		GetUserResponse response = new GetUserResponse();
		
		//Pagination Code
		Pageable page = PageRequest.of(pageNumber, numberOfRow);
		
		Page<User> getPagableUser = userRepo.findAll(QueryUtils.buildUserSpecification(firstName,email,phone), page);
		List<User> getUserList = getPagableUser.stream().collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(getUserList)) {
			response.setUser(getUserList);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/product")
	public ResponseEntity<?> getProduct(@Valid @RequestParam(name = "id", required = true) Integer id)
			throws BusinessException {
		 GetUserResponse response = demoService.getProductInfo(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/user")
	public ResponseEntity<?> createAddressInfo(@Valid @RequestBody CreateUserRequest request) {

		demoService.createUser(request);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/*
	 * @PutMapping(value = "/update") public ResponseEntity<Object>
	 * udateStudentInfo(@Valid @RequestBody Student getStudentInfo) throws
	 * ParseException { try { demoService.udateStudentInfo(getStudentInfo); } catch
	 * (ConstraintViolationException | DataIntegrityViolationException e) { throw
	 * new BusinessException("Error while Update into Student table", "ERROR_02"); }
	 * return new ResponseEntity<>(HttpStatus.OK); }
	 * 
	 * @DeleteMapping(value = "/delete") public ResponseEntity<String>
	 * deleteStudentInfo(@Valid @RequestParam(name = "id", required = true) Integer
	 * id) { demoService.deleteStudentInfo(id); return new ResponseEntity<>("",
	 * HttpStatus.OK);
	 * 
	 * }
	 */

}
