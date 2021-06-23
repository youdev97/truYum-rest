package com.cognizant.truyum.dao;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		testAddCartItem();
//		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2);
		cartDao.addCartItem(1, 1);
		try {
			System.out.println(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			System.out.println(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 2);
		try {
			System.out.println(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

}
