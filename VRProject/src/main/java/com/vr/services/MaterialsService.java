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

import com.vr.daos.MaterialsDao;
import com.vr.pojos.Materials;

@Path("/materials")
public class MaterialsService {
	// URI:
	// /contextPath/servletPath/materials
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Materials> findAll() {
		List<Materials> l = MaterialsDao.findAll();
		return l;
	}

	// URI:
	// /contextPath/servletPath/materials/{mId}
	@GET
	@Path("/{mId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Materials find(@PathParam("mId") int mId) {
		return MaterialsDao.find(mId);
	}

	// URI:
	// /contextPath/servletPath/materials
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Materials materials) {
		return MaterialsDao.create(materials);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Materials materials) {
		return MaterialsDao.edit(materials);
	}

	@DELETE
	@Path("/{mId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("mId") int mId) {
		MaterialsDao.remove(mId);
	}

}
