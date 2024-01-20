package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.example.demo.entity.Address;
import com.example.demo.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "first_name")
	private String firstName;
	@JsonProperty(value = "last_name")
	private String lastName;
	@JsonProperty(value = "phone")
	private Integer phone;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "address")
	private Address address;
	@JsonProperty(value = "product")
	private List<Product> product;

	public CreateUserRequest(String firstName, String lastName, Integer phone, String email, Address address,
			List<Product> product) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.product = product;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstName, lastName, phone, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateUserRequest other = (CreateUserRequest) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phone, other.phone) && Objects.equals(product, other.product);
	}

	@Override
	public String toString() {
		return "CreateUserRequest [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", product=" + product + "]";
	}

}
