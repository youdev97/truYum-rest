package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "INSERT into cart(cart_id, ct_us_id, ct_pr_id) VALUES ?,?,?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, menuItemId);
			pstmt.setLong(2, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		Cart cart = new Cart(new ArrayList<MenuItem>(), 0);
		List<MenuItem> menuItems = cart.getMenuItemList();
		Connection con = ConnectionHandler.getConnection();
		String sql = "SELECT m.* FROM cart c JOIN menu_item m on c.ct_pr_id=m.me_id WHERE c.ct_us_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				menuItems.add(new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
						rs.getBoolean("me_free_delivery")));
			}
			sql = "SELECT sum(m.me_price) as total FROM cart c JOIN menu_item m on c.ct_pr_id=m.me_id WHERE c.ct_us_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart.setTotal(rs.getDouble("total"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItems;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "DELETE FROM cart WHERE ct_us_id = ? AND ct_pr_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, userId);
			pstmt.setLong(2, menuItemId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
