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

import com.vr.daos.SessionsDao;
import com.vr.pojos.Sessions;

@Path("/sessions")
public class SessionsServices {
	// URI:
	// /contextPath/servletPath/sessions
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Sessions> findAll_JSON() {
		List<Sessions> l = SessionsDao.findAll();
		return l;
	}

	// URI:
	// /contextPath/servletPath/sessions/{sessId}
	@GET
	@Path("/{sessId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Sessions find(@PathParam("sessId") int sessId) {
		return SessionsDao.find(sessId);
	}

	// URI:
	// /contextPath/servletPath/sessions
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int create(Sessions sessions) {
		return SessionsDao.create(sessions);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean edit(Sessions sessions) {
		return SessionsDao.edit(sessions);
	}

	@DELETE
	@Path("/{sessId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("sessId") int sessId) {
		SessionsDao.remove(sessId);
	}

}
