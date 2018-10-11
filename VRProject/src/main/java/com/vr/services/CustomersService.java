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

import com.vr.daos.CustomersDao;
import com.vr.pojos.Customers;

@Path("/customers")
public class CustomersService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Customers> getApplication_JSON() {
		List<Customers> listOfApplication = CustomersDao.findAll();
		return listOfApplication;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{cId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Customers find(@PathParam("cId") int cId) {
		return CustomersDao.find(cId);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Customers app) {
		return CustomersDao.create(app);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Customers app) {
		return CustomersDao.edit(app);
	}

	@DELETE
	@Path("/{cId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean remove(@PathParam("cId") int cId) {
		return CustomersDao.remove(cId);
	}

}
