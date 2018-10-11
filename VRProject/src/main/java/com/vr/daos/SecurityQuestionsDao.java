package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;
import com.vr.pojos.SecurityQuestions;

public class SecurityQuestionsDao {
	public static int create(SecurityQuestions securityQuestions) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into securityquestions ( question, answer, cuid) " + "values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, securityQuestions.getQuestion());
			ps.setString(2, securityQuestions.getAnswer());
			ps.setInt(3, securityQuestions.getCuId());
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

	public static boolean edit(SecurityQuestions securityQuestions) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update securityquestions " + "set question = ?, answer = ?, cuid = ? where sqid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, securityQuestions.getQuestion());
			ps.setString(2, securityQuestions.getAnswer());
			ps.setInt(3, securityQuestions.getCuId());
			ps.setInt(4, securityQuestions.getSqId());
			ps.executeUpdate();

		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int sqId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from securityquestions where sqid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sqId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static SecurityQuestions find(int sqId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		SecurityQuestions securityQuestions = new SecurityQuestions();
		try {
			String sql = "select * from securityquestions where sqid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sqId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				securityQuestions.setSqId(sqId);
				securityQuestions.setQuestion(rs.getString("question"));
				securityQuestions.setAnswer(rs.getString("answer"));
				securityQuestions.setCuId(rs.getInt("cuid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return securityQuestions;
	}

	public static ArrayList<SecurityQuestions> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<SecurityQuestions> listSecurityQuestions = new ArrayList<SecurityQuestions>();
		try {
			String sql = "select * from securityQuestions";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SecurityQuestions securityQuestions = new SecurityQuestions();
				securityQuestions.setSqId(rs.getInt("sqid"));
				securityQuestions.setQuestion(rs.getString("question"));
				securityQuestions.setAnswer(rs.getString("answer"));
				securityQuestions.setCuId(rs.getInt("cuid"));
				listSecurityQuestions.add(securityQuestions);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listSecurityQuestions;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// SecurityQuestions securityQuestions = new SecurityQuestions("sasa", "sdsad" ,
		// 565);
		// System.out.println(SecurityQuestionsDao.create(securityQuestions));

		// SecurityQuestions securityQuestions = new SecurityQuestions(1, "sasa",
		// "sdsad" , 565);
		// System.out.println(SecurityQuestionsDao.edit(securityQuestions));

		// SecurityQuestionsDao.remove(1);

		// System.out.println(SecurityQuestionsDao.find(2));
		// System.out.println(SecurityQuestionsDao.findAll());
	}

}
