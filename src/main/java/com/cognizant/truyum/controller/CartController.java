package com.cognizant.truyum.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.TruyumNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable("userId") long userId, @PathVariable("menuItemId") long menuItemId) throws TruyumNotFoundException {
		log.info("Start adding Item " + menuItemId + "in the cart of user " + userId);
		cartService.addCartItem(userId, menuItemId);
		log.info("End adding item to cart");
	}

	@GetMapping("/{userId}")
	public CartDTO showCart(@PathVariable("userId") long userId) throws CartEmptyException, TruyumNotFoundException {
		log.info("Start show cart of user " + userId);
		CartDTO cart = new CartDTO();
		Set<MenuItem> menuItemList = cartService.getAllCartItems(userId);
		double total = cartService.getCartTotal(userId);
		cart.setMenuItems(menuItemList);
		cart.setTotal(total);
		log.info("End showing user's cart");
		return cart;
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable("userId") long userId, @PathVariable("menuItemId") long menuItemId) throws TruyumNotFoundException {
		log.info("Start delete item to user's cart");
		cartService.removeCartItem(userId, menuItemId);
		log.info("End delete item to user's cart");
	}
	
}