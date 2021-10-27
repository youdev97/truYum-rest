package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.TruyumNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	MenuItemRepository menuItemRepository;

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.findByActiveTrueAndDateOfLaunchLessThanEqual(new Date());
	}

	@Transactional
	public MenuItem getMenuItem(long menuItemId) throws TruyumNotFoundException {
		return menuItemRepository.findById(menuItemId).orElseThrow(() -> new TruyumNotFoundException("Menu Item " + menuItemId + " doesn't exist"));
	}

	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
	}

}
