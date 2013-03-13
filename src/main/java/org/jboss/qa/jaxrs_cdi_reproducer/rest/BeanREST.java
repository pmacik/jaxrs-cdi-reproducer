package org.jboss.qa.jaxrs_cdi_reproducer.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.qa.jaxrs_cdi_reproducer.dao.BeanDAO;
import org.jboss.qa.jaxrs_cdi_reproducer.model.Bean;

@Path("/bean")
@RequestScoped
public class BeanREST {

	@Inject
	private BeanDAO dao;

	@GET()
	@Produces("text/xml")
	@Path("/getAll")
	public List<Bean> findAll() {
		return dao.findAll();
	}

	@GET()
	@Produces("text/xml")
	@Path("/get/{id}")
	public Bean findById(@PathParam("id") Integer id) {
		return dao.findById(id);
	}

	@GET()
	@Produces("text/xml")
	@Path("/create/{name}")
	public Bean create(@PathParam("name") String name) {
		return dao.create(name);
	}

}
