package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.pojos.Customers;
import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;

public class CustomersDao {

	public static int create(Customers customer) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into customers (sid,name,address,city,mobile,email,lastvisit,status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, customer.getsId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getCity());
			ps.setString(5, customer.getMobile());
			ps.setString(6, customer.getEmail());
			java.sql.Date dt = new java.sql.Date(customer.getLastVisit().getTime());
			ps.setDate(7, dt);
			ps.setString(8, customer.getStatus());
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

	public static boolean edit(Customers customer) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "update customers set sid=?,name=?,address=?,city=?,mobile=?,email=?,lastvisit=?,status=? where cid=?";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, customer.getsId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getCity());
			ps.setString(5, customer.getMobile());
			ps.setString(6, customer.getEmail());
			java.sql.Date dt = new java.sql.Date(customer.getLastVisit().getTime());
			ps.setDate(7, dt);
			ps.setString(8, customer.getStatus());
			ps.setInt(9, customer.getcId());
			id = ps.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.putConnection(conn);
		}
		if (id != 0)
			return true;
		else
			return false;

	}

	public static boolean remove(int cid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from customers where cid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
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

	public static Customers find(int cid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Customers customer = new Customers();
		try {
			String sql = "select * from customers where cid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer.setcId(cid);
				customer.setsId(rs.getInt("sid"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setMobile(rs.getString("mobile"));
				customer.setEmail(rs.getString("email"));
				java.sql.Date dt = rs.getDate("lastvisit");
				customer.setLastVisit(new java.util.Date(dt.getTime()));
				customer.setStatus(rs.getString("status"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return customer;
	}

	public static ArrayList<Customers> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Customers> customerlist = new ArrayList<>();
		try {
			String sql = "select * from customers ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customers customer = new Customers();
				customer.setcId(rs.getInt("cid"));
				customer.setsId(rs.getInt("sid"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setMobile(rs.getString("mobile"));
				customer.setEmail(rs.getString("email"));
				java.sql.Date dt = rs.getDate("lastvisit");
				customer.setLastVisit(new java.util.Date(dt.getTime()));
				customer.setStatus(rs.getString("status"));
				customerlist.add(customer);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return customerlist;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("28-05-2018");
		//
		// Customers customer = new Customers(1,"xyz","xyz","xyz","xyz","xyz",dt,"xyz");
		// CustomerDao cust = new CustomerDao();
		// System.out.println(cust.create(customer));

		// java.util.Date dt = DateUtils.convertDate("28-05-2018");
		//
		// Customers customer = new
		// Customers(5,1,"xayz","xayz","xayz","xayz","xayz",dt,"xayz");
		// CustomerDao cust = new CustomerDao();
		// System.out.println(cust.edit(customer));

		// CustomerDao cust = new CustomerDao();
		// System.out.println(cust.remove(5));

		// CustomerDao cust = new CustomerDao();
		// System.out.println(cust.find(4));

		CustomersDao cust = new CustomersDao();
		System.out.println(cust.findAll());
	}

}
