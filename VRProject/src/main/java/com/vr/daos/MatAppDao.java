package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;
import com.vr.pojos.MatApp;

public class MatAppDao {

	public static int create(MatApp matApp) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into matApp ( mid, aid) " + "values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, matApp.getmId());
			ps.setInt(2, matApp.getaId());
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

	public static boolean edit(MatApp matApp) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update matApp " + "set mid = ?, aid = ? where maid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, matApp.getmId());
			ps.setInt(2, matApp.getaId());
			ps.setInt(3, matApp.getMaId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int MaId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from matapp where maid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, MaId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static MatApp find(int MaId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		MatApp matApp = new MatApp();
		try {
			String sql = "select * from matapp where maid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, MaId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				matApp.setMaId(MaId);
				matApp.setmId(rs.getInt("mid"));
				matApp.setaId(rs.getInt("aid"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return matApp;
	}

	public static ArrayList<MatApp> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<MatApp> listMatApp = new ArrayList<MatApp>();
		try {
			String sql = "select * from matapp";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MatApp matApp = new MatApp();
				matApp.setMaId(rs.getInt("maid"));
				matApp.setmId(rs.getInt("mid"));
				matApp.setaId(rs.getInt("aid"));
				listMatApp.add(matApp);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listMatApp;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// MatApp matApp = new MatApp(88, 89);
		// System.out.println(MatAppDao.create(matApp));

		// MatApp matApp = new MatApp(1, 66, 88);
		// System.out.println(MatAppDao.edit(matApp));

		// MatAppDao.remove(1);

		// System.out.println(MatAppDao.find(2));
		// System.out.println(MatAppDao.findAll());
	}
}
