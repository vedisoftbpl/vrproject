package com.vr.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.vr.daos.*;
import com.vr.pojos.*;

@Path("/grades")
public class GradesService {

	// URI:
	// /contextPath/servletPath/grades
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Grades> findAll_JSON() {
		List<Grades> l = GradesDao.findAll();
		return l;
	}

	// URI:
	// /contextPath/servletPath/grades/{gId}
	@GET
	@Path("/{gId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Grades find(@PathParam("gId") int gId) {
		return GradesDao.find(gId);
	}

	// URI:
	// /contextPath/servletPath/grades
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Grades grades) {
		return GradesDao.create(grades);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Grades grades) {
		return GradesDao.edit(grades);
	}

	@DELETE
	@Path("/{gId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("gId") int gId) {
		GradesDao.remove(gId);
	}

}
