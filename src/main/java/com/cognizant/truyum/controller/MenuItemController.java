package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.TruyumNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	@GetMapping
	public List<MenuItem> getAllMenuItems() {
		log.info("Start Get All Menu Items");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		log.info("End Get All Menu Items");
		return menuItemList;
	}

	@GetMapping("/{menuItemId}")
	public MenuItem getMenuItem(@PathVariable("menuItemId") long menuItemId) throws TruyumNotFoundException {
		log.info("Start Get Menu Item " + menuItemId);
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		log.info("End Get Menu Item");
		return menuItem;
	}

	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		log.info("Start Modify Menu Item " + menuItem);
		menuItemService.modifyMenuItem(menuItem);
		log.info("End Modify Menu Item");
	}

}
