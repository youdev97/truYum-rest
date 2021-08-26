package com.cognizant.truyum.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CartController {

	@Autowired
	CartService cartService;

	@GetMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam("menuItemId") long menuItemId, RedirectAttributes redirectAttributes) {
		log.info("Start");
		cartService.addCartItem(1, menuItemId);
		redirectAttributes.addFlashAttribute("addCartStatus", true);
		log.info("End");
		return "redirect:/show-menu-list-customer";
	}

	@GetMapping(value = "/show-cart")
	public String showCart(@RequestParam("userId") long userId, ModelMap model) {
		log.info("Start");
		CartDTO cart = getAllCartItems(userId);
		model.addAttribute("cart", cart);
		log.info("End");
		return "cart";
	}

	@GetMapping(value = "/remove-cart")
	public String removeCart(@RequestParam("menuItemId") long menuItemId, @RequestParam("userId") long userId,
			RedirectAttributes redirectAttributes) {
		log.info("Start");
		cartService.removeCartItem(userId, menuItemId);
		redirectAttributes.addFlashAttribute("removeCartItemStatus", true);
		log.info("End");
		return "redirect:/show-cart?userId="+userId;
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