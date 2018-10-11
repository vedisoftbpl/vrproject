package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Sessions;
import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;

public class SessionsDao {
	public static int create(Sessions sessions) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into sessions ( cid, sdatetime, edatetime) " + "values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, sessions.getcId());
			java.sql.Date dt = new java.sql.Date(sessions.getsDateTime().getTime());
			ps.setDate(2, dt);
			dt = new java.sql.Date(sessions.geteDateTime().getTime());
			ps.setDate(3, dt);
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

	public static boolean edit(Sessions sessions) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update sessions " + "set cid = ?, sdatetime = ?, edatetime = ? where sessid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, sessions.getcId());
			java.sql.Date dt = new java.sql.Date(sessions.getsDateTime().getTime());
			ps.setDate(2, dt);
			dt = new java.sql.Date(sessions.geteDateTime().getTime());
			ps.setDate(3, dt);
			ps.setInt(4, sessions.getSessId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int sessId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from sessions where sessid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sessId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static Sessions find(int sessId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Sessions sessions = new Sessions();
		try {
			String sql = "select * from sessions where sessid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sessId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sessions.setSessId(sessId);
				sessions.setcId(rs.getInt("cid"));
				java.sql.Date dt = rs.getDate("sdatetime");
				sessions.setsDateTime(new java.util.Date(dt.getTime()));
				dt = rs.getDate("edatetime");
				sessions.seteDateTime(new java.util.Date(dt.getTime()));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return sessions;
	}

	public static ArrayList<Sessions> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Sessions> listSessions = new ArrayList<Sessions>();
		try {
			String sql = "select * from sessions";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sessions sessions = new Sessions();
				sessions.setSessId(rs.getInt("sessid"));
				sessions.setcId(rs.getInt("cid"));
				java.sql.Date dt = rs.getDate("sdatetime");
				sessions.setsDateTime(new java.util.Date(dt.getTime()));
				dt = rs.getDate("edatetime");
				sessions.seteDateTime(new java.util.Date(dt.getTime()));
				listSessions.add(sessions);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listSessions;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// Sessions sessions = new Sessions(88, dt, dt1);
		// System.out.println(SessionsDao.create(sessions));

		// Sessions sessions = new Sessions(1, 66, dt, dt);
		// System.out.println(SessionsDao.edit(sessions));

		// SessionsDao.remove(1);

		// System.out.println(SessionsDao.find(6));
		System.out.println(SessionsDao.findAll());
	}
}