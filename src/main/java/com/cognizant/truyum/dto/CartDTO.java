package com.cognizant.truyum.dto;

import java.util.Set;

import com.cognizant.truyum.model.MenuItem;

public class CartDTO {

	private long id;
	private Set<MenuItem> menuItems;
	private double total;

	public CartDTO(Set<MenuItem> menuItems, double total) {
		super();
		this.menuItems = menuItems;
		this.total = total;
	}
	
	public CartDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItems + ", total=" + total + "]";
	}

}
