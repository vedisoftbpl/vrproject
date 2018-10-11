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

import com.vr.daos.CImagesDao;
import com.vr.pojos.CImages;

@Path("/cimages")
public class CImagesService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CImages> findAll() {
		List<CImages> listOfCimage = CImagesDao.findAll();
		return listOfCimage;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{ciId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CImages find(@PathParam("ciId") int ciId) {
		return CImagesDao.find(ciId);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(CImages app) {
		return CImagesDao.create(app);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(CImages app) {
		return CImagesDao.edit(app);
	}

	@DELETE
	@Path("/{ciId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean remove(@PathParam("ciId") int ciId) {
		return CImagesDao.remove(ciId);
	}

}
