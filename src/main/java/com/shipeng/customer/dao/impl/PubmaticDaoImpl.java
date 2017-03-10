package com.shipeng.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.shipeng.customer.model.Pubmatic;

public class PubmaticDaoImpl {
	private static final Logger logger = Logger
			.getLogger(PubmaticDaoImpl.class);
	
	private BasicDataSource dataSource;
	
	// DI setter
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Pubmatic pubmatic) {

		String sql = "INSERT INTO pubmatic_bidid_siteid "
				+ "(bid_id, site_id) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, pubmatic.getBidId());
			ps.setString(2, pubmatic.getSiteId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			logger.error("This is Error message", new Exception("Testing"));
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	
	/*
	public Customer findByCustomerId(int custId) {

		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("CUST_ID"),
						rs.getString("NAME"), rs.getInt("Age"));
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	*/
	
	
	
	
} //end class PubmaticDaoImpl
	


