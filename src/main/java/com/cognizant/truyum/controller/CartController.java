package com.cognizant.truyum.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@GetMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam("menuItemId") long menuItemId, RedirectAttributes redirectAttributes) {
		LOGGER.info("Start");
		cartService.addCartItem(1, menuItemId);
		redirectAttributes.addFlashAttribute("addCartStatus", true);
		LOGGER.info("End");
		return "redirect:/show-menu-list-customer";
	}

	@GetMapping(value = "/show-cart")
	public String showCart(@RequestParam("userId") long userId, ModelMap model) {
		LOGGER.info("Start");
		CartDTO cart = getAllCartItems(userId);
		model.addAttribute("cart", cart);
		LOGGER.info("End");
		return "cart";
	}

	@GetMapping(value = "/remove-cart")
	public String removeCart(@RequestParam("menuItemId") long menuItemId, @RequestParam("userId") long userId,
			ModelMap model) {
		LOGGER.info("Start");
		cartService.removeCartItem(userId, menuItemId);
		model.addAttribute("removeCartItemStatus", true);
		LOGGER.info("End");
		return "cart";
	}

	CartDTO getAllCartItems(long userId) {
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