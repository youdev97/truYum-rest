package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping(value="/add-to-cart")
	public String addToCart(@RequestParam("menuItemId") long menuItemId, RedirectAttributes redirectAttributes) {
		LOGGER.info("Start");
		//cartService.addCartitem(1, menuItemId);
		redirectAttributes.addFlashAttribute("addCartStatus", true);
		LOGGER.info("End");
		return "redirect:/show-menu-list-customer";
	}
	
	@GetMapping(value="/show-cart")
	public String showCart(@RequestParam("userId") long userId, ModelMap model) {
		LOGGER.info("Start");
		try {
			Cart cart = cartService.getAllCartItems(userId);
			model.addAttribute("cart", cart);
			LOGGER.info("End");
			return "cart";
		} catch (CartEmptyException e) {
			e.printStackTrace();
			LOGGER.info("End");
			return "cart-empty";
		}
	}
	
	@GetMapping(value="/remove-cart")
	public String removeCart(@RequestParam("userId") long userId, @RequestParam("menuItemId") long menuItemId, ModelMap model) {
		LOGGER.info("Start");
		cartService.removeCartItem(userId, menuItemId);
		try {
			Cart cart = cartService.getAllCartItems(userId);
			model.addAttribute("removeCartItemStatus", true);
			LOGGER.info("End");
			return "cart";
		} catch (CartEmptyException e) {
			e.printStackTrace();
			LOGGER.info("End");
			return "cart-empty";
		}
	}
}