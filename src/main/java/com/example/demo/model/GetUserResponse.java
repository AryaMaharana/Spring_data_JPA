package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public class GetUserResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<User> user;
	private List<Product> product;

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetUserResponse other = (GetUserResponse) obj;
		return Objects.equals(product, other.product) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "GetUserResponse [user=" + user + ", product=" + product + "]";
	}

}
