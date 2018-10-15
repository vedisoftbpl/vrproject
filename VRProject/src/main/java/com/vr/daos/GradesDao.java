package com.vr.daos;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;
import com.vr.pojos.Grades;

public class GradesDao {

	public static int create(Grades grades) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into grades ( mcid, g_name, g_details, status, lastmodified) " + "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, grades.getMcId());
			ps.setString(2, grades.getgName());
			ps.setString(3, grades.getgDetails());
			ps.setString(4, grades.getStatus());
			java.sql.Time lastModified = new java.sql.Time(new java.util.Date().getTime());
			ps.setTime(5, lastModified);

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

	public static boolean edit(Grades grades) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update grades "
					+ "set mcid = ?, g_name = ? , g_details = ?, status = ?, lastmodified = ? where gid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, grades.getMcId());
			ps.setString(2, grades.getgName());
			ps.setString(3, grades.getgDetails());
			ps.setString(4, grades.getStatus());
			java.sql.Time lastModified = new java.sql.Time(new java.util.Date().getTime());
			ps.setTime(5, lastModified);
			ps.setInt(6, grades.getgId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int gId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from grades where gid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static Grades find(int gId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Grades grades = new Grades();
		try {
			String sql = "select * from grades where gid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				grades.setgId(gId);
				grades.setMcId(rs.getInt("mcid"));
				grades.setgName(rs.getString("g_name"));
				grades.setgDetails(rs.getString("g_details"));
				grades.setStatus(rs.getString("status"));
				java.sql.Timestamp dt = rs.getTimestamp("lastModified");
				grades.setLastModified(new java.util.Date(dt.getTime()));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return grades;
	}

	public static ArrayList<Grades> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Grades> listGrades = new ArrayList<Grades>();
		try {
			String sql = "select * from grades";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Grades grades = new Grades();
				grades.setgId(rs.getInt("gid"));
				grades.setMcId(rs.getInt("mcid"));
				grades.setgName(rs.getString("g_name"));
				grades.setgDetails(rs.getString("g_details"));
				grades.setStatus(rs.getString("status"));
				java.sql.Timestamp dt = rs.getTimestamp("lastModified");
				grades.setLastModified(new java.util.Date(dt.getTime()));
				listGrades.add(grades);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listGrades;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// Grades grades = new Grades(88, "dad", "dwqd", "sasqw");
		// System.out.println(GradesDao.create(grades));

		// Grades grades = new Grades(1, 88, "dad", "dwqd", "sasqw", dt);
		// System.out.println(GradesDao.edit(grades));

		// GradesDao.remove(1);

		// System.out.println(GradesDao.find(2));
		// System.out.println(GradesDao.findAll());
	}
}
