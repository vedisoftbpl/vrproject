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

import com.vr.daos.ApplicationsDao;
import com.vr.pojos.Applications;

@Path("/applications")
public class ApplicationsService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Applications> getApplication_JSON() {
		List<Applications> listOfApplication = ApplicationsDao.findAll();
		return listOfApplication;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{aId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Applications find(@PathParam("aId") int aId) {
		return ApplicationsDao.find(aId);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Applications app) {
		return ApplicationsDao.create(app);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Applications app) {
		return ApplicationsDao.edit(app);
	}

	@DELETE
	@Path("/{aid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean remove(@PathParam("aid") int aId) {
		return ApplicationsDao.remove(aId);
	}

}
