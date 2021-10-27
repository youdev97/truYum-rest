package com.cognizant.truyum.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.TruyumNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	UserService userService;

	@Autowired
	MenuItemService menuItemService;

	@Transactional
	public Set<MenuItem> getAllCartItems(long userId) throws CartEmptyException, TruyumNotFoundException {
		User user = userService.getUser(userId);
		if (user.getCart().isEmpty()) {
			throw new CartEmptyException("Cart of user " + userId + " is empty");
		}
		Set<MenuItem> cartItemList = new HashSet<>();
		for (Cart cart : user.getCart()) {
			cartItemList.add(cart.getMenuItem());
		}
		return cartItemList;
	}

	@Transactional
	public double getCartTotal(long userId) {
		return userService.getCartTotal(userId);
	}

	@Transactional
	public void addCartItem(long userId, long menuItemId) throws TruyumNotFoundException {
		User user = userService.getUser(userId);
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setMenuItem(menuItem);
		cartRepository.save(cart);
	}

	@Transactional
	public void removeCartItem(long userId, long menuItemId) throws TruyumNotFoundException {
		User user = userService.getUser(userId);
		boolean found = false;
		for (Cart cart : user.getCart()) {
			if (cart.getMenuItem().getId() == menuItemId) {
				found = true;
				cartRepository.delete(cart);
				break;
			}
		}
		if(!found) {
			throw new TruyumNotFoundException("Menu Item " + menuItemId + " wasn't found in user's "+ userId + " cart");
		}
	}
}
