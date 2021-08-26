package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

//@Component(value = "menuItemDao")
//public class MenuItemDaoSqlImpl implements MenuItemDao {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoSqlImpl.class);
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Override
//	public List<MenuItem> getMenuItemListAdmin() {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<MenuItem> menuItems = new ArrayList<MenuItem>();
//		String sql = "SELECT * FROM menu_item";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				menuItems.add(new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
//						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
//						rs.getBoolean("me_free_delivery")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try { if (rs != null) rs.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//
//		LOGGER.info("End");
//		return menuItems;
//	}
//
//	@Override
//	public List<MenuItem> getMenuItemListCustomer() {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<MenuItem> menuItems = new ArrayList<MenuItem>();
//		String sql = "SELECT * FROM menu_item WHERE me_active > 0 && me_date_of_launch <= CURRENT_DATE";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				menuItems.add(new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
//						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
//						rs.getBoolean("me_free_delivery")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try { if (rs != null) rs.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//		LOGGER.info("End");
//		return menuItems;
//	}
//
//	@Override
//	public void modifyMenuItem(MenuItem menuItem) {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "UPDATE menu_item SET me_name=? me_price=? me_active=? me_date_of_launch=? me_category=? me_free_delivery=? WHERE me_id = ?";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, menuItem.getName());
//			pstmt.setFloat(2, menuItem.getPrice());
//			pstmt.setBoolean(3, menuItem.isActive());
//			pstmt.setDate(4, (java.sql.Date) menuItem.getDateOfLaunch());
//			pstmt.setString(5, menuItem.getCategory());
//			pstmt.setBoolean(6, menuItem.isFreeDelivery());
//			pstmt.setLong(7, menuItem.getId());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				menuItem = new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
//						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
//						rs.getBoolean("me_free_delivery"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try { if (rs != null) rs.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//		LOGGER.info("End");
//
//	}
//
//	@Override
//	public MenuItem getMenuItem(long menuItemId) {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		MenuItem menuItem = null;
//		String sql = "SELECT * FROM menu_item WHERE me_id = ?";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setLong(1, menuItemId);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				menuItem = new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
//						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
//						rs.getBoolean("me_free_delivery"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try { if (rs != null) rs.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//		LOGGER.info("End");
//		return menuItem;
//	}
//
//}
