package com.cognizant.truyum.controller;

import java.util.List;

import javax.transaction.SystemException;
import javax.validation.Valid;

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

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	
	@GetMapping(value = "/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws SystemException {
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		model.addAttribute("menuItemList", menuItemList);
		log.info("End");
		return "menu-item-list-admin";
	}
	
	@GetMapping(value = "/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException {
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		model.addAttribute("menuItemList", menuItemList);
		log.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") long menuItemId, ModelMap model) {
		log.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		model.addAttribute("menuItemBean", menuItem);
		log.info("End");
		return "edit-menu-item";

	}

	@PostMapping(value = "/edit-menu-item")
	public String editMenuItem(@ModelAttribute("menuItemBean") @Valid MenuItem menuItem, BindingResult bindingResult) {
		log.info("Start");
		if (bindingResult.hasErrors()) {
			return "edit-menu-item";			
		} else {
			menuItemService.modifyMenuItem(menuItem);
			log.info("End");
			return "edit-menu-item-status";
		}
	}

}
