package com.cognizant.truyum.controller;

import java.util.List;

import javax.transaction.SystemException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		model.addAttribute("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-admin";
	}
	
	@GetMapping(value = "/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		model.addAttribute("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") long menuItemId, ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		model.addAttribute("menuItemBean", menuItem);
		LOGGER.info("End");
		return "edit-menu-item";

	}

	@PostMapping(value = "/edit-menu-item")
	public String editMenuItem(@ModelAttribute("menuItemBean") @Valid MenuItem menuItem, BindingResult bindingResult) {
		LOGGER.info("Start");
		if (bindingResult.hasErrors()) {
			return "edit-menu-item";			
		} else {
			menuItemService.modifyMenuItem(menuItem);
			LOGGER.info("End");
			return "edit-menu-item-status";
		}
	}

}
