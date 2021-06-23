package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuItem);
		} else {
			Cart newCart = new Cart(new ArrayList<>(), 0);
			newCart.getMenuItemList().add(menuItem);
			userCarts.put(userId, newCart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> cartItems = null;
		if (userCarts.containsKey(userId)) {
			cartItems = userCarts.get(userId).getMenuItemList();
			if(cartItems.isEmpty()) {
				throw new CartEmptyException();
			} else {
				double total=0;
				for(MenuItem item : cartItems) {
					total += item.getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
		}
		return cartItems;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		if(userCarts.containsKey(userId)) {
			ListIterator<MenuItem> iter = userCarts.get(userId).getMenuItemList().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getId() == menuItemId) {
					iter.remove();
				}
			}
		}

	}

}
