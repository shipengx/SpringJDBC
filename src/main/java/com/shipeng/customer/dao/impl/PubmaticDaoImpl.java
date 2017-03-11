package com.shipeng.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.shipeng.customer.model.Pubmatic;

public class PubmaticDaoImpl {
	private static final Logger logger = Logger
			.getLogger(PubmaticDaoImpl.class);

	private BasicDataSource dataSource;
	private final String insertPubmaticSql = "insert into pubmatic_bidid_siteid (bid_id, site_id) values (?, ?) ";
	private final String getPubmaticListSql = "SELECT * FROM pubmatic_bidid_siteid limit 6 ";

	// DI setter
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Pubmatic pubmatic) {
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(insertPubmaticSql);
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

	public void ingestLogs(List<Pubmatic> pubmaticList) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		final int batchSize = 1000;
		int count = 0;
		int insertionCount = 0;

		try {
			int[] tmpCount = null;
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(this.insertPubmaticSql);
			for (Pubmatic pubmatic : pubmaticList) {

				ps.setLong(1, pubmatic.getBidId());
				ps.setString(2, pubmatic.getSiteId());
				ps.addBatch();

				if (++count % batchSize == 0) {
					tmpCount = ps.executeBatch();
					insertionCount += tmpCount.length;
				}
			}
			tmpCount = ps.executeBatch();
			insertionCount += tmpCount.length;
			logger.info("[PubmaticDaoImpl.ingestLogs] - "
					+ "Number of bid_id, siteId inserted: " + insertionCount);
			tmpCount = null;
			ps.close();
			conn.close();
		} catch (SQLException se) {
			logger.error("[PubmaticDaoImpl.ingestLogs] - "
					+ se.getMessage());
		} catch (Exception e) {
			logger.error("[PubmaticDaoImpl.ingestLogs] - "
					+ e.getMessage());
		}

	} // ingestLogs
	
	
	
	public List<Pubmatic> getPubmaticList() {
		List<Pubmatic> result = new ArrayList<Pubmatic>();
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(getPubmaticListSql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new Pubmatic(rs.getLong("bid_id"), rs.getString("site_id")));
			}
			rs.close();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

} // end class PubmaticDaoImpl

