package com.cognizant.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		User user = userRepository.getMenuItems();
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void addCartitem(long userId, long menuItemId) {
		User user = userRepository.getOne(userId);
		MenuItem menuItem = menuItemRepository.getOne(menuItemId);
		user.getCarts()
	}

	public void removeCartItem(long userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
