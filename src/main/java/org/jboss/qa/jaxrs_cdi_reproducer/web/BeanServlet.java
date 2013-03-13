package org.jboss.qa.jaxrs_cdi_reproducer.web;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.qa.jaxrs_cdi_reproducer.dao.BeanDAO;

@RequestScoped
public class BeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private BeanDAO dao;

	public BeanServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(dao);
	}

}
