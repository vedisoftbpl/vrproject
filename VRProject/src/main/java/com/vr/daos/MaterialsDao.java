package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;
import com.vr.pojos.Materials;

public class MaterialsDao {
	public static int create(Materials materials) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into materials ( mcid, gid, aid, code, m_name, image, image3d, status, lastmodified, priority) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, materials.getMcId());
			ps.setInt(2, materials.getgId());
			ps.setInt(3, materials.getaId());
			ps.setInt(4, materials.getCode());
			ps.setString(5, materials.getmName());
			ps.setString(6, materials.getImage());
			ps.setString(7, materials.getImage3d());
			ps.setString(8, materials.getStatus());
			java.sql.Date dt = new java.sql.Date(materials.getLastModified().getTime());
			ps.setDate(9, dt);
			ps.setInt(10, materials.getPriority());
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

	public static boolean edit(Materials materials) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update materials " + "set mcid = ? , gid = ? , aid = ? , code = ? ,"
					+ " m_name = ? , image = ? , image3d = ? , status = ? , lastmodified = ? ,"
					+ " priority = ? where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, materials.getMcId());
			ps.setInt(2, materials.getgId());
			ps.setInt(3, materials.getaId());
			ps.setInt(4, materials.getCode());
			ps.setString(5, materials.getmName());
			ps.setString(6, materials.getImage());
			ps.setString(7, materials.getImage3d());
			ps.setString(8, materials.getStatus());
			java.sql.Date dt = new java.sql.Date(materials.getLastModified().getTime());
			ps.setDate(9, dt);
			ps.setInt(10, materials.getPriority());
			ps.setInt(11, materials.getmId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int mId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from materials where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static Materials find(int mId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Materials materials = new Materials();
		try {
			String sql = "select * from materials where mid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				materials.setmId(mId);
				materials.setMcId(rs.getInt("mcid"));
				materials.setgId(rs.getInt("gid"));
				materials.setaId(rs.getInt("aid"));
				materials.setCode(rs.getInt("code"));
				materials.setmName(rs.getString("m_name"));
				materials.setImage(rs.getString("image"));
				materials.setImage3d(rs.getString("image3d"));
				materials.setStatus(rs.getString("status"));
				java.sql.Date dt = rs.getDate("lastmodified");
				materials.setLastModified(new java.util.Date(dt.getTime()));
				materials.setPriority(rs.getInt("priority"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return materials;
	}

	public static ArrayList<Materials> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Materials> listMaterials = new ArrayList<Materials>();
		try {
			String sql = "select * from materials";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materials materials = new Materials();
				materials.setmId(rs.getInt("mid"));
				materials.setMcId(rs.getInt("mcid"));
				materials.setgId(rs.getInt("gid"));
				materials.setaId(rs.getInt("aid"));
				materials.setCode(rs.getInt("code"));
				materials.setmName(rs.getString("m_name"));
				materials.setImage(rs.getString("image"));
				materials.setImage3d(rs.getString("image3d"));
				materials.setStatus(rs.getString("status"));
				java.sql.Date dt = rs.getDate("lastmodified");
				materials.setLastModified(new java.util.Date(dt.getTime()));
				materials.setPriority(rs.getInt("priority"));
				listMaterials.add(materials);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listMaterials;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// Materials materials = new Materials(88, 9878, 5454, 445, "saas", "saas",
		// "saas", "saas", dt1, 59 );
		// System.out.println(MaterialsDao.create(materials));

		// Materials materials = new Materials(1, 88, 9878, 5454, 445, "saas", "saas",
		// "saas", "saas", dt1, 59 );
		// System.out.println(MaterialsDao.edit(materials));

		// MaterialsDao.remove(1);

		// System.out.println(MaterialsDao.find(2));
		// System.out.println(MaterialsDao.findAll());
	}

}
