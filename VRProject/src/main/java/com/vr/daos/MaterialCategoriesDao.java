package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;
import com.vr.pojos.MaterialCategories;

public class MaterialCategoriesDao {

	public static int create(MaterialCategories materialCategories) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into materialcategories ( clientid, mc_name, mc_details, mc_pic, status, lastmodified) "
					+ "values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, materialCategories.getClientId());
			ps.setString(2, materialCategories.getMcName());
			ps.setString(3, materialCategories.getMcDetails());
			ps.setString(4, materialCategories.getMcPic());
			ps.setString(5, materialCategories.getStatus());
			java.sql.Date dt = new java.sql.Date(materialCategories.getLastModified().getTime());
			ps.setDate(6, dt);
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

	public static boolean edit(MaterialCategories materialCategories) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update materialCategories "
					+ "set clientid = ?, mc_name = ?, mc_details = ?, mc_pic = ?, status = ?, lastmodified = ? where mcid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, materialCategories.getClientId());
			ps.setString(2, materialCategories.getMcName());
			ps.setString(3, materialCategories.getMcDetails());
			ps.setString(4, materialCategories.getMcPic());
			ps.setString(5, materialCategories.getStatus());
			java.sql.Date dt = new java.sql.Date(materialCategories.getLastModified().getTime());
			ps.setDate(6, dt);
			ps.setInt(7, materialCategories.getMcId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int McId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from materialcategories where mcid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, McId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static MaterialCategories find(int McId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		MaterialCategories materialCategories = new MaterialCategories();
		try {
			String sql = "select * from materialcategories where mcid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, McId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				materialCategories.setMcId(McId);
				materialCategories.setClientId(rs.getInt("clientid"));
				materialCategories.setMcName(rs.getString("mc_name"));
				materialCategories.setMcDetails(rs.getString("mc_details"));
				materialCategories.setMcPic(rs.getString("mc_pic"));
				materialCategories.setStatus(rs.getString("status"));
				java.sql.Date dt = rs.getDate("lastmodified");
				materialCategories.setLastModified(new java.util.Date(dt.getTime()));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return materialCategories;
	}

	public static ArrayList<MaterialCategories> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<MaterialCategories> listMaterialCategories = new ArrayList<MaterialCategories>();
		try {
			String sql = "select * from materialCategories";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MaterialCategories materialCategories = new MaterialCategories();
				materialCategories.setMcId(rs.getInt("mcid"));
				materialCategories.setClientId(rs.getInt("clientid"));
				materialCategories.setMcName(rs.getString("mc_name"));
				materialCategories.setMcDetails(rs.getString("mc_details"));
				materialCategories.setMcPic(rs.getString("mc_pic"));
				materialCategories.setStatus(rs.getString("status"));
				java.sql.Date dt = rs.getDate("lastmodified");
				materialCategories.setLastModified(new java.util.Date(dt.getTime()));
				listMaterialCategories.add(materialCategories);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listMaterialCategories;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("22-04-2018");
		java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// MaterialCategories materialCategories = new MaterialCategories(88, "ADWADA",
		// "ASDASD", "JYUUYU", "cojisjdis",dt);
		// System.out.println(MaterialCategoriesDao.create(materialCategories));

		MaterialCategories materialCategories = new MaterialCategories(1, 88, "ADWADA", "ASDASD", "JYUUYU", "cojisjdis",
				dt);
		System.out.println(MaterialCategoriesDao.edit(materialCategories));

		// MaterialCategoriesDao.remove(1);

		// System.out.println(MaterialCategoriesDao.find(6));
		System.out.println(MaterialCategoriesDao.findAll());
	}
}
