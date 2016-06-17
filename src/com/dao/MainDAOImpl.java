package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.beans.IPRange;
import com.beans.IPv4;
import com.beans.Location;

@Component
public class MainDAOImpl implements MainDAO {
	
	
	public MainDAOImpl() {
		Connection conn = null;
		try {
			conn = ConnectionConfiguration.getConnection();
			if (conn != null) {
				System.out.println("Connection Live");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public List<IPRange> getAllRanges() {
		List<IPRange> addresses = new ArrayList<IPRange>();
		IPRange range = null;
		IPv4 bottom = new IPv4();
		IPv4 top = new IPv4();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = ConnectionConfiguration.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ip_range");

			while (rs.next()) {
				
				range = new IPRange();
				top = new IPv4();
				bottom = new IPv4();
				range.setBottom(bottom);
				range.setTop(top);
				
				String bottomString = rs.getString("bottom");
				String topString = rs.getString("top");
				String[] bottomParts = bottomString.split(Pattern.quote("."));
				String[] topParts = topString.split(Pattern.quote("."));
				range.getBottom().setFirst(Integer.parseInt(bottomParts[0]));
				range.getBottom().setSecond(Integer.parseInt(bottomParts[1]));
				range.getBottom().setThird(Integer.parseInt(bottomParts[2]));
				range.getBottom().setFourth(Integer.parseInt(bottomParts[3]));
				range.getTop().setFirst(Integer.parseInt(topParts[0]));
				range.getTop().setSecond(Integer.parseInt(topParts[1]));
				range.getTop().setThird(Integer.parseInt(topParts[2]));
				range.getTop().setFourth(Integer.parseInt(topParts[3]));
				range.setId(rs.getInt("id"));
				addresses.add(range);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return addresses;
	}

	public List<Location> getLocations() {
		
		List<Location> locations = new ArrayList<Location>();
		Location location = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = ConnectionConfiguration.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM location");

			while (rs.next()) {
				
				location = new Location();
				location.setId(rs.getInt("id"));
				location.setIpRangeId(rs.getInt("ip_range_id"));
				location.setCity(rs.getString("city"));
				location.setCountry(rs.getString("country"));
				locations.add(location);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return locations;
	}
}
