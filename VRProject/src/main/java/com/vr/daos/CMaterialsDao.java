package com.vr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.pojos.CMaterials;
import com.vr.utilities.ConnectionPool;

public class CMaterialsDao {

	public static int create(CMaterials cmaterial) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into cmaterials (caid,mid) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cmaterial.getCaId());
			ps.setInt(2, cmaterial.getmId());
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

	public static boolean edit(CMaterials cmaterial) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "update cmaterials set caid = ?,mid=? where cmid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cmaterial.getCaId());
			ps.setInt(2, cmaterial.getmId());
			ps.setInt(3, cmaterial.getCmId());
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

	public static boolean remove(int cmid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from cmaterials where cmid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cmid);
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

	public static CMaterials find(int cmid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		CMaterials cmaterial = new CMaterials();
		try {
			String sql = "select * from cmaterials where cmid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cmid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cmaterial.setCmId(cmid);
				cmaterial.setCaId((rs.getInt("caid")));
				cmaterial.setmId(rs.getInt("mid"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return cmaterial;
	}

	public static ArrayList<CMaterials> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CMaterials> cmateriallist = new ArrayList<CMaterials>();
		try {
			String sql = "select * from cmaterials";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CMaterials cmaterial = new CMaterials();
				cmaterial.setCmId(rs.getInt("cmid"));
				cmaterial.setCaId((rs.getInt("caid")));
				cmaterial.setmId(rs.getInt("mid"));
				cmateriallist.add(cmaterial);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return cmateriallist;
	}

	public static void main(String args[]) {
		// Cmaterials cmaterial = new Cmaterials(3,6);
		// CmaterialsDao cmaterial1 = new CmaterialsDao();
		// System.out.println(cmaterial1.create(cmaterial));
		//
		// Cmaterials cmaterial = new Cmaterials(3,7,3);
		// CmaterialsDao cmaterial1 = new CmaterialsDao();
		// System.out.println(cmaterial1.edit(cmaterial));

		// CmaterialsDao cmaterial1 = new CmaterialsDao();
		// System.out.println(cmaterial1.remove(3));

		// CmaterialsDao cmaterial1 = new CmaterialsDao();
		// System.out.println(cmaterial1.find(2));

		CMaterialsDao cmaterial1 = new CMaterialsDao();
		System.out.println(cmaterial1.findAll());

	}
}
