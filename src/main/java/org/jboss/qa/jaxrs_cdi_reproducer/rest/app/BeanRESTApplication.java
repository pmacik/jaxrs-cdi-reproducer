package org.jboss.qa.jaxrs_cdi_reproducer.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.qa.jaxrs_cdi_reproducer.rest.BeanREST;

@ApplicationPath("/rest")
public class BeanRESTApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public BeanRESTApplication() {
		singletons.add(new BeanREST());
		classes.add(BeanREST.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
