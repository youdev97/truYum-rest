package com.cognizant.truyum.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
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
	public void addCartItem(@PathVariable("userId") long userId, @PathVariable("menuItemId") long menuItemId) {
		log.info("Start");
		cartService.addCartItem(userId, menuItemId);
		log.info("End");
	}

	@GetMapping("/{userId}")
	public Set<MenuItem> showCart(@PathVariable("userId") long userId) {
		log.info("Start");
		CartDTO cart = getAllCartItems(userId);
		log.info("End");
		return cart.getMenuItems();
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable("userId") long userId, 
			@PathVariable("menuItemId") long menuItemId) {
		log.info("Start");
		cartService.removeCartItem(userId, menuItemId);
		log.info("End");
	}

	public CartDTO getAllCartItems(long userId) {
		CartDTO cart = new CartDTO();
		try {
			Set<MenuItem> menuItemList = cartService.getAllCartItems(userId);
			double total = cartService.getCartTotal(userId);
			cart.setMenuItems(menuItemList);
			cart.setTotal(total);
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
		return cart;
	}
}