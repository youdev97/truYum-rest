package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	
	public static void main(String[] args) {
//		testGetMenuItemListAdmin();
//		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}
	
	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems = menuItemDao.getMenuItemListAdmin();
		menuItems.forEach(System.out::println);
	}
	
	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems = menuItemDao.getMenuItemListCustomer();
		menuItems.forEach(System.out::println);
	}
	
	public static void testModifyMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println(menuItemDao.getMenuItem(1));
		MenuItem menuItem1 = new MenuItem(1, "Durum", 10.00f, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		menuItemDao.modifyMenuItem(menuItem1);
		System.out.println(menuItemDao.getMenuItem(1));
	}
	
	public static void testGetMenuItem() {
		
	}
}
