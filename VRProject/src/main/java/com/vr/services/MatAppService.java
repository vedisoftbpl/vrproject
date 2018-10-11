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

import com.vr.daos.MatAppDao;
import com.vr.pojos.MatApp;

@Path("/matapp")
public class MatAppService {
	// URI:
	// /contextPath/servletPath/MatApp
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<MatApp> findAll() {
		List<MatApp> l = MatAppDao.findAll();
		return l;
	}

	// URI:
	// /contextPath/servletPath/MatApp/{maId}
	@GET
	@Path("/{maId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MatApp find(@PathParam("maId") int maId) {
		return MatAppDao.find(maId);
	}

	// URI:
	// /contextPath/servletPath/MatApp
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(MatApp MatApp) {
		return MatAppDao.create(MatApp);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(MatApp MatApp) {
		return MatAppDao.edit(MatApp);
	}

	@DELETE
	@Path("/{maId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("maId") int maId) {
		MatAppDao.remove(maId);
	}
}
