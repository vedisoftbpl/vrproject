package com.vr.daos;

import java.awt.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.utilities.ConnectionPool;

public class ApplicationsDao {

	public static int create(Applications application) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into applications (a_name) values(?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, application.getaName());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.putConnection(conn);
		}
		return id;

	}

	public static boolean edit(Applications application) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "update applications set a_name = ? where aid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, application.getaName());
			ps.setInt(2, application.getaId());
			count = ps.executeUpdate();

		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		if (count != 0)
			return true;
		else
			return false;
	}

	public static boolean remove(int aid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from applications where aid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			count = ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		if (count != 0)
			return true;
		else
			return false;
	}

	public static Applications find(int aid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Applications application = new Applications();
		try {
			String sql = "select * from applications where aid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				application.setaId(aid);
				application.setaName((rs.getString("a_name")));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return application;
	}

	public static ArrayList<Applications> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Applications> applicationlist = new ArrayList<Applications>();
		try {
			String sql = "select * from applications";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Applications application = new Applications();
				application.setaId(rs.getInt("aid"));
				application.setaName((rs.getString("a_name")));
				applicationlist.add(application);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return applicationlist;
	}

	public static void main(String args[]) {
		// APPLICATION APPLICATION = NEW APPLICATION(1,"SHUBHAM");
		// APPLICATIONDAO APP1 = NEW APPLICATIONDAO();
		// SYSTEM.OUT.PRINTLN(APP1.CREATE(APPLICATION));

		// Application application = new Application(57,"subhanu");
		// ApplicationDao app1 = new ApplicationDao();
		// System.out.println(app1.edit(application));

		// Application application = new Application(57);
		// ApplicationDao app1 = new ApplicationDao();
		// System.out.println(app1.remove(57));

		// Applications application = new Applications(57);
		// ApplicationsDao app1 = new ApplicationsDao();
		// System.out.println(app1.find(60));

		// Applications application = new Applications(57);
		// ApplicationsDao app1 = new ApplicationsDao();
		// System.out.println(ApplicationsDao.findAll());
	}

}
