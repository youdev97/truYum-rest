package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		String sql = "SELECT * FROM menu_item";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				menuItems.add(new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
						rs.getBoolean("me_free_delivery")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItems;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		String sql = "SELECT * FROM menu_item WHERE me_active > 0 && me_date_of_launch <= CURRENT_DATE";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				menuItems.add(new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
						rs.getBoolean("me_free_delivery")));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItems;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "UPDATE menu_item SET me_name=? me_price=? me_active=? me_date_of_launch=? me_category=? me_free_delivery=? WHERE me_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menuItem.getName());
			pstmt.setFloat(2, menuItem.getPrice());
			pstmt.setBoolean(3, menuItem.isActive());
			pstmt.setDate(4, (java.sql.Date) menuItem.getDateOfLaunch());
			pstmt.setString(5, menuItem.getCategory());
			pstmt.setBoolean(6, menuItem.isFreeDelivery());
			pstmt.setLong(7, menuItem.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				menuItem = new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
						rs.getBoolean("me_free_delivery"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		Connection con = ConnectionHandler.getConnection();
		String sql = "SELECT * FROM menu_item WHERE me_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, menuItemId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				menuItem = new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
						rs.getBoolean("me_free_delivery"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItem;
	}

}
