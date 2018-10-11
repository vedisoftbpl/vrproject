package com.vr.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vr.daos.ClientUsersDao;
import com.vr.pojos.ClientUsers;

@Path("/clientusers")
public class ClientUsersService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ClientUsers> getApplication_JSON() {
		List<ClientUsers> listOfApplication = ClientUsersDao.findAll();
		return listOfApplication;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{cuId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ClientUsers find(@PathParam("cuId") int cuId) {
		return ClientUsersDao.find(cuId);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(ClientUsers app) {
		return ClientUsersDao.create(app);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(ClientUsers app) {
		return ClientUsersDao.edit(app);
	}

	@DELETE
	@Path("/{cuId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean remove(@PathParam("cuId") int cuId) {
		return ClientUsersDao.remove(cuId);
	}

}
