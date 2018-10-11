package com.vr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.pojos.CApplications;
import com.vr.utilities.ConnectionPool;

public class CApplicationsDao {

	public static int create(CApplications capplication) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into capplications (sessid,cid,aid,aid_no) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, capplication.getSessId());
			ps.setInt(2, capplication.getcId());
			ps.setInt(3, capplication.getaId());
			ps.setInt(4, capplication.getAidNo());
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

	public static boolean edit(CApplications capplication) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "update capplications set sessid = ?,cid=?,aid=?,aid_no=? where caid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, capplication.getSessId());
			ps.setInt(2, capplication.getcId());
			ps.setInt(3, capplication.getaId());
			ps.setInt(4, capplication.getAidNo());
			ps.setInt(5, capplication.getCaId());
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

	public static boolean remove(int caid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from capplications where caid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, caid);
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

	public static CApplications find(int aid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		CApplications capplication = new CApplications();
		try {
			String sql = "select * from capplications where caid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				capplication.setCaId(aid);
				;
				capplication.setSessId(rs.getInt("sessid"));
				capplication.setcId(rs.getInt("cid"));
				capplication.setaId(rs.getInt("aid"));
				capplication.setAidNo(rs.getInt("aid_no"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return capplication;
	}

	public static ArrayList<CApplications> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CApplications> applicationlist = new ArrayList<>();
		try {
			String sql = "select * from capplications";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CApplications capplication = new CApplications();
				capplication.setCaId(rs.getInt("caid"));
				;
				capplication.setSessId(rs.getInt("sessid"));
				capplication.setcId(rs.getInt("cid"));
				capplication.setaId(rs.getInt("aid"));
				capplication.setAidNo(rs.getInt("aid_no"));
				applicationlist.add(capplication);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return applicationlist;
	}

	public static void main(String args[]) {
		// Capplication capplication = new Capplication(7,8,5,7);
		// CapplicationsDao appDao = new CapplicationsDao();
		// System.out.println(appDao.create(capplication));

		// Capplication capplication = new Capplication(4,7,8,5,7);
		// CapplicationsDao appDao = new CapplicationsDao();
		// System.out.println(appDao.edit(capplication));

		// //Capplication capplication = new Capplication(4,7,8,5,7);
		// CapplicationsDao appDao = new CapplicationsDao();
		// System.out.println(appDao.remove(4));

		// Capplication capplication = new Capplication(4,7,8,5,7);
		// CapplicationsDao appDao = new CapplicationsDao();
		// System.out.println(appDao.find(2));

		CApplicationsDao appDao = new CApplicationsDao();
		System.out.println(appDao.findAll());

	}

}
