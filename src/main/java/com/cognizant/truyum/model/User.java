package com.cognizant.truyum.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private long id;

	@Column(name = "us_name")
	private String name;

	@OneToMany(mappedBy = "user")
	private Set<Cart> cart;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

}
