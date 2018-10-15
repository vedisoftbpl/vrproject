package com.vr.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Timestamp;

import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;
import com.vr.pojos.Sites;

public class SitesDao {
	public static int create(Sites sites) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into sites ( inst_id, inst_date, valid_upto, sitename, address, city, state, country, pin, website, email, contact_person, designation, mobile, contact_email, status, lastmodified, lastsyn) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, sites.getInstId());
			java.sql.Date dt = new java.sql.Date(sites.getInstDate().getTime());
			ps.setDate(2, dt);
			dt = new java.sql.Date(sites.getValidUpto().getTime());
			ps.setDate(3, dt);
			ps.setString(4, sites.getSiteName());
			ps.setString(5, sites.getAddress());
			ps.setString(6, sites.getCity());
			ps.setString(7, sites.getState());
			ps.setString(8, sites.getCountry());
			ps.setString(9, sites.getPin());
			ps.setString(10, sites.getWebsite());
			ps.setString(11, sites.getEmail());
			ps.setString(12, sites.getContactPerson());
			ps.setString(13, sites.getDesignation());
			ps.setString(14, sites.getMobile());
			ps.setString(15, sites.getContactEmail());
			ps.setString(16, sites.getStatus());

			java.sql.Time LastModified = new java.sql.Time(new java.util.Date().getTime());
			ps.setTime(17, LastModified);

			java.sql.Time lstsyn = new java.sql.Time(new java.util.Date().getTime());
			ps.setTime(18, lstsyn);
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}

	public static boolean edit(Sites sites) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update sites set inst_id = ?, inst_date = ?, valid_upto = ?, sitename = ?, address = ?,"
					+ " city = ?, state = ?, country = ?, pin = ?, website = ?, email = ?, contact_person = ?,"
					+ " designation = ?, mobile = ?, contact_email = ?, status = ?,"
					+ " lastmodified = ?, lastsyn = ? where sid = ? ";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, sites.getInstId());
			java.sql.Date dt = new java.sql.Date(sites.getInstDate().getTime());
			ps.setDate(2, dt);
			dt = new java.sql.Date(sites.getValidUpto().getTime());
			ps.setDate(3, dt);
			ps.setString(4, sites.getSiteName());
			ps.setString(5, sites.getAddress());
			ps.setString(6, sites.getCity());
			ps.setString(7, sites.getState());
			ps.setString(8, sites.getCountry());
			ps.setString(9, sites.getPin());
			ps.setString(10, sites.getWebsite());
			ps.setString(11, sites.getEmail());
			ps.setString(12, sites.getContactPerson());
			ps.setString(13, sites.getDesignation());
			ps.setString(14, sites.getMobile());
			ps.setString(15, sites.getContactEmail());
			ps.setString(16, sites.getStatus());
			java.sql.Time dt1 = new java.sql.Time(sites.getLastModified().getTime());
			ps.setTime(17, dt1);
			dt1 = new java.sql.Time(sites.getLastSyn().getTime());
			ps.setTime(18, dt1);
			ps.setInt(19, sites.getsId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int sId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from sites where sid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static Sites find(int sId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Sites sites = new Sites();
		try {
			String sql = "select * from sites where sid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sites.setsId(sId);
				sites.setInstId(rs.getInt("inst_id"));
				Timestamp dt = rs.getTimestamp("inst_date");
				sites.setInstDate(new java.util.Date(dt.getTime()));
				dt = rs.getTimestamp("valid_upto");
				sites.setValidUpto(new java.util.Date(dt.getTime()));
				sites.setSiteName(rs.getString("sitename"));
				sites.setAddress(rs.getString("address"));
				sites.setCity(rs.getString("city"));
				sites.setState(rs.getString("state"));
				sites.setCountry(rs.getString("country"));
				sites.setPin(rs.getString("pin"));
				sites.setWebsite(rs.getString("website"));
				sites.setEmail(rs.getString("email"));
				sites.setContactPerson(rs.getString("contact_person"));
				sites.setDesignation(rs.getString("designation"));
				sites.setMobile(rs.getString("mobile"));
				sites.setContactEmail(rs.getString("contact_email"));
				sites.setStatus(rs.getString("status"));
				java.sql.Timestamp dt1 = rs.getTimestamp("lastmodified");
				sites.setLastModified(new java.util.Date(dt1.getTime()));
				dt1 = rs.getTimestamp("lastSyn");
				sites.setLastSyn(new java.util.Date(dt1.getTime()));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return sites;
	}

	public static ArrayList<Sites> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Sites> listSites = new ArrayList<Sites>();
		try {
			String sql = "select * from sites";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sites sites = new Sites();
				sites.setsId(rs.getInt("sid"));
				sites.setInstId(rs.getInt("inst_id"));
				java.sql.Timestamp dt = rs.getTimestamp("inst_date");
				sites.setInstDate(new java.util.Date(dt.getTime()));
				dt = rs.getTimestamp("valid_upto");
				sites.setValidUpto(new java.util.Date(dt.getTime()));
				sites.setSiteName(rs.getString("sitename"));
				sites.setAddress(rs.getString("address"));
				sites.setCity(rs.getString("city"));
				sites.setState(rs.getString("state"));
				sites.setCountry(rs.getString("country"));
				sites.setPin(rs.getString("pin"));
				sites.setWebsite(rs.getString("website"));
				sites.setEmail(rs.getString("email"));
				sites.setContactPerson(rs.getString("contact_person"));
				sites.setDesignation(rs.getString("designation"));
				sites.setMobile(rs.getString("mobile"));
				sites.setContactEmail(rs.getString("contact_email"));
				sites.setStatus(rs.getString("status"));
				java.sql.Timestamp dt1 = rs.getTimestamp("lastmodified");
				sites.setLastModified(new java.util.Date(dt1.getTime()));
				dt1 = rs.getTimestamp("lastSyn");
				sites.setLastSyn(new java.util.Date(dt1.getTime()));
				listSites.add(sites);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listSites;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// Sites sites = new Sites(88, dt, dt1, "asdsd", "asdsd", "asdsd", "asdsd",
		// "asdsd", "asdsd", "asdsd", "asdsd",
		// "asdsd", "asdsd", "asdsd", "asdsd", "asdsd");
		// System.out.println(SitesDao.create(sites));

		// Sites sites = new Sites(9, 88, dt, dt1, "asdsd", "asdsd", "asdsd", "asdsd",
		// "asdsd", "asdsd", "asdsd", "asdsd",
		// "asdsd", "asdsd", "asdsd", "asdsd", "asdsd",dt , dt1);
		// // Sites sites = new Sites(1, 66, dt, dt);
		// System.out.println(SitesDao.edit(sites));

		// SitesDao.remove(1);

		// System.out.println(SitesDao.find(10));
		// System.out.println(SitesDao.findAll());
	}
}
