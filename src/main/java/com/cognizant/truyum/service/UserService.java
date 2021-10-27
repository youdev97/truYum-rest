package com.cognizant.truyum.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.TruyumNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Transactional
	public User getUser(long id) throws TruyumNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new TruyumNotFoundException("User " + id + " doesn't exist"));
	}
	
	@Transactional
	public void modifyUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional
	public double getCartTotal(long userId) {
		return userRepository.getCartTotal(userId);
	}
	
	@Transactional
	public void deleteCartItem(long userId, long menuItemId) {
		User user = userRepository.getMenuItems(userId);
		List<Cart> found = new ArrayList<Cart>();
		for(Cart cart : user.getCart()) {
			if(menuItemId == cart.getMenuItem().getId()) {
				found.add(cart);
			}
		}
		user.getCart().removeAll(found);
		userRepository.save(user);
	}

}
