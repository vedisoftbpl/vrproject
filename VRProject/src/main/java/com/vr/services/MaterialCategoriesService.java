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

import com.vr.daos.MaterialCategoriesDao;
import com.vr.pojos.MaterialCategories;

@Path("/materialcategories")
public class MaterialCategoriesService {
    // URI:
    // /contextPath/servletPath/MaterialCategories
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<MaterialCategories> findAll() {
        List<MaterialCategories> l = MaterialCategoriesDao.findAll();
        return l;
    }
 
    // URI:
    // /contextPath/servletPath/MaterialCategories/{mcId}
    @GET
    @Path("/{mcId}")	
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public MaterialCategories find(@PathParam("mcId") int mcId) {
        return MaterialCategoriesDao.find(mcId);
    }
 
    // URI:
    // /contextPath/servletPath/MaterialCategories
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int create(MaterialCategories MaterialCategories) {
        return MaterialCategoriesDao.create(MaterialCategories);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean edit(MaterialCategories MaterialCategories) {
        return MaterialCategoriesDao.edit(MaterialCategories);
    }
 
    @DELETE
    @Path("/{mcId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void remove(@PathParam("mcId") int mcId) {
        MaterialCategoriesDao.remove(mcId);
    }
}
