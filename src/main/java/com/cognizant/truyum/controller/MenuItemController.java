package com.cognizant.truyum.controller;

import java.util.List;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<MenuItem> getAllMenuItems() throws SystemException {
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		log.info("End");
		return menuItemList;
	}

	@GetMapping("/{menuItemId}")
	public MenuItem getMenuItem(@PathVariable("menuItemId") long menuItemId) {
		log.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		log.info("End");
		return menuItem;
	}

	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		log.info("Start");
		menuItemService.modifyMenuItem(menuItem);
		log.info("End");
	}

}
