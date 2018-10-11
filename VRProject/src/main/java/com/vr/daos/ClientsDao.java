package com.vr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vr.pojos.Applications;
import com.vr.pojos.Clients;
import com.vr.utilities.ConnectionPool;
import com.vr.utilities.DateUtils;

public class ClientsDao {

	public static int create(Clients clients) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "insert into clients(client_name,address,city,state,country,pin,website,email,contact_person,designation,mobile,contact_email,status,lastmodified) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, clients.getClientName());
			ps.setString(2, clients.getAddress());
			ps.setString(3, clients.getCity());
			ps.setString(4, clients.getState());
			ps.setString(5, clients.getCountry());
			ps.setString(6, clients.getPin());
			ps.setString(7, clients.getWebsite());
			ps.setString(8, clients.getEmail());
			ps.setString(9, clients.getContactPerson());
			ps.setString(10, clients.getDesignation());
			ps.setString(11, clients.getMobile());
			ps.setString(12, clients.getContactEmail());
			ps.setString(13, clients.getStatus());
			java.sql.Date dt = new java.sql.Date(clients.getLastModified().getTime());
			ps.setDate(14, dt);
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

	public static boolean edit(Clients clients) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String query = "update clients set client_name=?,address=?,city=?,state=?,country=?,pin=?,website=?,email=?,contact_person=?,designation=?,mobile=?,contact_email=?,status=?,lastmodified=? where clientid=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, clients.getClientName());
			ps.setString(2, clients.getAddress());
			ps.setString(3, clients.getCity());
			ps.setString(4, clients.getState());
			ps.setString(5, clients.getCountry());
			ps.setString(6, clients.getPin());
			ps.setString(7, clients.getWebsite());
			ps.setString(8, clients.getEmail());
			ps.setString(9, clients.getContactPerson());
			ps.setString(10, clients.getDesignation());
			ps.setString(11, clients.getMobile());
			ps.setString(12, clients.getContactEmail());
			ps.setString(13, clients.getStatus());
			java.sql.Date dt = new java.sql.Date(clients.getLastModified().getTime());
			ps.setDate(14, dt);
			ps.setInt(15, clients.getClientId());
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

	public static boolean remove(int clientid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int count = 0;
		try {
			String sql = "delete from clients where clientid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, clientid);
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

	public static Clients find(int clientid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Clients clients = new Clients();
		try {
			String sql = "select * from clients where clientid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, clientid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clients.setClientId(clientid);
				clients.setClientName(rs.getString("client_name"));
				clients.setAddress(rs.getString("address"));
				clients.setCity(rs.getString("city"));
				clients.setState(rs.getString("state"));
				clients.setCountry(rs.getString("country"));
				clients.setPin(rs.getString("pin"));
				clients.setWebsite(rs.getString("website"));
				clients.setEmail(rs.getString("email"));
				clients.setContactPerson(rs.getString("contact_person"));
				clients.setDesignation(rs.getString("designation"));
				clients.setMobile(rs.getString("mobile"));
				clients.setContactEmail(rs.getString("contact_email"));
				clients.setStatus(rs.getString("status"));
				java.sql.Date dt = rs.getDate("lastmodified");
				clients.setLastModified(new java.util.Date(dt.getTime()));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return clients;
	}

	public static ArrayList<Clients> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Clients> clientlist = new ArrayList<>();
		try {
			String sql = "select * from clients";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Clients clients = new Clients();
				clients.setClientId(rs.getInt("clientid"));
				clients.setClientName(rs.getString("client_name"));
				clients.setAddress(rs.getString("address"));
				clients.setCity(rs.getString("city"));
				clients.setState(rs.getString("state"));
				clients.setCountry(rs.getString("country"));
				clients.setPin(rs.getString("pin"));
				clients.setWebsite(rs.getString("website"));
				clients.setEmail(rs.getString("email"));
				clients.setContactPerson(rs.getString("contact_person"));
				clients.setDesignation(rs.getString("designation"));
				clients.setMobile(rs.getString("mobile"));
				clients.setContactEmail(rs.getString("contact_email"));
				clients.setStatus(rs.getString("status"));
				java.sql.Date dt = rs.getDate("lastmodified");
				clients.setLastModified(new java.util.Date(dt.getTime()));
				clientlist.add(clients);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return clientlist;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("28-05-2018");
		//
		// Clients client = new
		// Clients("xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz",dt);
		// ClientsDao clients1 = new ClientsDao();
		// System.out.println(clients1.create(client));

		// java.util.Date dt = DateUtils.convertDate("28-05-2018");

		// Clients client = new
		// Clients(3,"xayz","xayz","xayz","xayz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz",dt);
		// ClientsDao clients1 = new ClientsDao();
		// System.out.println(clients1.edit(client));

		// ClientsDao clients1 = new ClientsDao();
		// System.out.println(clients1.remove(2));

		// ClientsDao clients1 = new ClientsDao();
		// System.out.println(clients1.find(3));

		ClientsDao clients1 = new ClientsDao();
		System.out.println(clients1.findAll());

	}

}
