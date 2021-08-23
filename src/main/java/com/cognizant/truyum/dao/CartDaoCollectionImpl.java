package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

//@Component
//public class CartDaoCollectionImpl implements CartDao {
//	
//	private static HashMap<Long, Cart> userCarts;
//
//	public CartDaoCollectionImpl() {
//		super();
//		if (userCarts == null) {
//			userCarts = new HashMap<Long, Cart>();
//		}
//	}
//
//	@Override
//	public void addCartItem(long userId, long menuItemId) {
//		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
//		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
//
//		if (userCarts.containsKey(userId)) {
//			Set<MenuItem> menuItems = userCarts.get(userId).getMenuItems();
//			menuItems.add(menuItem);
//		} else {
//			Cart cart = new Cart(new HashSet<MenuItem>(), 0.0);
//			cart.getMenuItems().add(menuItem);
//			userCarts.put(userId, cart);
//		}
//	}
//
//	@Override
//	public Cart getAllCartItems(long userId) throws CartEmptyException {
//		if (userCarts.containsKey(userId)) {
//			Set<MenuItem> menuItems = userCarts.get(userId).getMenuItems();
//			if (menuItems.isEmpty()) {
//				throw (new CartEmptyException());
//			} else {
//				double total = 0.0;
//				for(MenuItem menuItem : menuItems) {
//					total += menuItem.getPrice();
//				}
//				userCarts.get(userId).setTotal(total);
//			}
//			return userCarts.get(userId);
//		} else {
//			throw (new CartEmptyException());
//		}
//
//	}
//
//	@Override
//	public void removeCartItem(long userId, long menuItemId) {
//		Set<MenuItem> menuItems = userCarts.get(userId).getMenuItems();
//		for (MenuItem menuItem : menuItems) {
//			if (menuItem.getId() == menuItemId) {
//				menuItems.remove(menuItem);
//				break;
//			}
//		}
//	}
//
//}
