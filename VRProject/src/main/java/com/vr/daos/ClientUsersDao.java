package com.vr.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.pojos.ClientUsers;
import com.vr.utilities.ConnectionPool;

public class ClientUsersDao {

	public static int create(ClientUsers clientuser) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into clientusers (clientid,email,password,person,designation,status) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, clientuser.getClientId());
			ps.setString(2, clientuser.getEmail());
			ps.setString(3, clientuser.getPassword());
			ps.setString(4, clientuser.getPerson());
			ps.setString(5, clientuser.getDesignation());
			ps.setString(6, clientuser.getStatus());

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

	public static boolean edit(ClientUsers clientuser) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String query = "update clientusers set clientid=?,email=?,password=?,person=?,designation=?,status=? where cuid=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, clientuser.getClientId());
			ps.setString(2, clientuser.getEmail());
			ps.setString(3, clientuser.getPassword());
			ps.setString(4, clientuser.getPerson());
			ps.setString(5, clientuser.getDesignation());
			ps.setString(6, clientuser.getStatus());
			ps.setInt(7, clientuser.getCuId());
			count = ps.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.putConnection(conn);
		}
		if (count != 0)
			return true;
		else
			return false;

	}

	public static boolean remove(int cuid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from clientusers where cuid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cuid);
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

	public static ClientUsers find(int cuid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ClientUsers clientuser = new ClientUsers();
		try {
			String query = "select * from clientusers where cuid=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cuid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clientuser.setCuId(cuid);
				clientuser.setClientId(rs.getInt("clientid"));
				clientuser.setEmail(rs.getString("email"));
				clientuser.setPassword(rs.getString("password"));
				clientuser.setPerson(rs.getString("person"));
				clientuser.setDesignation(rs.getString("designation"));
				clientuser.setStatus(rs.getString("status"));
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.putConnection(conn);
		}
		return clientuser;

	}

	public static ArrayList<ClientUsers> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ClientUsers> clientuserlist = new ArrayList<>();
		try {
			String query = "select * from clientusers";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ClientUsers clientuser = new ClientUsers();
				clientuser.setCuId(rs.getInt("cuid"));
				clientuser.setClientId(rs.getInt("clientid"));
				clientuser.setEmail(rs.getString("email"));
				clientuser.setPassword(rs.getString("password"));
				clientuser.setPerson(rs.getString("person"));
				clientuser.setDesignation(rs.getString("designation"));
				clientuser.setStatus(rs.getString("status"));
				clientuserlist.add(clientuser);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.putConnection(conn);
		}
		return clientuserlist;

	}

	public static void main(String args[]) {
		// Clientusers clientuser = new Clientusers(2,"xyz","xyz","xyz","xyz","xyz");
		// ClientusersDao client = new ClientusersDao();
		// System.out.println(client.create(clientuser));

		// Clientusers clientuser = new
		// Clientusers(2,2,"xayz","xayz","xayz","xayz","xayz");
		// ClientusersDao client = new ClientusersDao();
		// System.out.println(client.edit(clientuser));

		// ClientusersDao client = new ClientusersDao();
		// System.out.println(client.remove(2));

		// ClientusersDao client = new ClientusersDao();
		// System.out.println(client.find(3));

		ClientUsersDao client = new ClientUsersDao();
		System.out.println(client.findAll());
	}

}
