package com.vr.services;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vr.daos.ClientsDao;
import com.vr.pojos.Clients;

@Path("/clients")
public class ClientsService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Clients> findAll() {
		ArrayList<Clients> listOfApplication = ClientsDao.findAll();
		return listOfApplication;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{clientId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Clients find(@PathParam("clientId") int clientId) {
		return ClientsDao.find(clientId);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Clients app) {
		return ClientsDao.create(app);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Clients app) {
		return ClientsDao.edit(app);
	}

	@DELETE
	@Path("/{clientId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean remove(@PathParam("clientId") int clientId) {
		return ClientsDao.remove(clientId);
	}

}
