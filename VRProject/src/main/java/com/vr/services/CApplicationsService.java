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

import com.vr.daos.CApplicationsDao;

import com.vr.pojos.CApplications;

@Path("/capplications")
public class CApplicationsService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CApplications> findAll() {
		List<CApplications> listOfApplication = CApplicationsDao.findAll();
		return listOfApplication;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{caId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CApplications find(@PathParam("caId") int caId) {
		return CApplicationsDao.find(caId);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(CApplications app) {
		return CApplicationsDao.create(app);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(CApplications app) {
		return CApplicationsDao.edit(app);
	}

	@DELETE
	@Path("/{caid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean remove(@PathParam("caid") int caId) {
		return CApplicationsDao.remove(caId);
	}

}
