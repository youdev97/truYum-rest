package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

//@Component(value = "cartDao")
//public class CartDaoSqlImpl implements CartDao {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoSqlImpl.class);
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Override
//	public void addCartItem(long userId, long menuItemId) {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "INSERT into cart(cart_id, ct_us_id, ct_pr_id) VALUES ?,?,?";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setLong(1, menuItemId);
//			pstmt.setLong(2, userId);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//		LOGGER.info("End");
//	}
//
//	@Override
//	public Cart getAllCartItems(long userId) throws CartEmptyException {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Cart cart = new Cart(new HashSet<MenuItem>(), 0);
//		Set<MenuItem> menuItems = cart.getMenuItems();
//		String sql = "SELECT m.* FROM cart c JOIN menu_item m on c.ct_pr_id=m.me_id WHERE c.ct_us_id=?";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setLong(1, userId);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				menuItems.add(new MenuItem(rs.getInt("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
//						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
//						rs.getBoolean("me_free_delivery")));
//			}
//			sql = "SELECT sum(m.me_price) as total FROM cart c JOIN menu_item m on c.ct_pr_id=m.me_id WHERE c.ct_us_id=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setLong(1, userId);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				cart.setTotal(rs.getDouble("total"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try { if (rs != null) rs.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//		LOGGER.info("End");
//		return cart;
//	}
//
//	@Override
//	public void removeCartItem(long userId, long menuItemId) {
//		LOGGER.info("Start");
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "DELETE FROM cart WHERE ct_us_id = ? AND ct_pr_id = ?";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setLong(1, userId);
//			pstmt.setLong(2, menuItemId);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//		    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();};
//		    try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();};
//		}
//		LOGGER.info("End");
//	}
//
//}
