package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.pojos.CImages;
import com.vr.utilities.ConnectionPool;

public class CImagesDao {

	public static int create(CImages cimage) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into cimages (caid,image) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cimage.getCaId());
			ps.setString(2, cimage.getImage());
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

	public static boolean edit(CImages cimage) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "update cimages set caid = ?,image=? where ciid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, cimage.getCaId());
			ps.setString(2, cimage.getImage());
			ps.setInt(3, cimage.getCiId());
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

	public static boolean remove(int ciid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from cimages where ciid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ciid);
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

	public static CImages find(int ciid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		CImages cimage = new CImages();
		try {
			String sql = "select * from cimages where ciid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ciid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cimage.setCiId(ciid);
				cimage.setCaId(rs.getInt("caid"));
				;
				cimage.setImage(rs.getString("image"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return cimage;
	}

	public static ArrayList<CImages> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CImages> cimagelist = new ArrayList<>();
		try {
			String sql = "select * from cimages";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CImages cimage = new CImages();
				cimage.setCiId(rs.getInt("ciid"));
				cimage.setCaId(rs.getInt("caid"));
				;
				cimage.setImage(rs.getString("image"));
				cimagelist.add(cimage);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return cimagelist;
	}

	public static void main(String args[]) {

		// Cimage cimage = new Cimage(1,"img1");
		// CimagesDao cimage1 = new CimagesDao();
		// System.out.print(cimage1.create(cimage));
		//

		// Cimage cimage = new Cimage(2,3,"img2");
		// CimagesDao cimage1 = new CimagesDao();
		// System.out.print(cimage1.edit(cimage));

		// CimagesDao cimage1 = new CimagesDao();
		// System.out.print(cimage1.remove(2));

		// CimagesDao cimage1 = new CimagesDao();
		// System.out.print(cimage1.find(3));
		//
		CImagesDao cimage1 = new CImagesDao();
		System.out.print(cimage1.findAll());
	}
}
