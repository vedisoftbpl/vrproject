package com.vr.services;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vr.daos.SitesDao;
import com.vr.pojos.Sites;

@Path("/sites")
public class SitesServices {
	// URI:
	// /contextPath/servletPath/Sites
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Sites> findAll() {
		List<Sites> l = SitesDao.findAll();
		return l;
	}

	// URI:
	// /contextPath/servletPath/Sites/{gId}
	@GET
	@Path("/{gId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Sites find(@PathParam("gId") int gId) {
		return SitesDao.find(gId);
	}

	// URI:
	// /contextPath/servletPath/Sites
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Sites Sites) {
		return SitesDao.create(Sites);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Sites Sites) {
		return SitesDao.edit(Sites);
	}

	@DELETE
	@Path("/{gId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("gId") int gId) {
		SitesDao.remove(gId);
	}

}
