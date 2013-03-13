package org.jboss.qa.jaxrs_cdi_reproducer.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.qa.jaxrs_cdi_reproducer.model.Bean;

@Named
@SessionScoped
public class BeanDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "primaryPU")
	private EntityManager em;

	public BeanDAO() {
		super();
	}

	public List<Bean> findAll() {
		TypedQuery<Bean> tq = em.createNamedQuery(Bean.FIND_ALL,
				Bean.class);
		return tq.getResultList();
	}

	public Bean findById(Integer id) {
		TypedQuery<Bean> tq = em.createNamedQuery(Bean.FIND_BY_ID,
				Bean.class);
		tq.setParameter(Bean.NQ_ID, id);
		return tq.getSingleResult();
	}

	public Bean create(String name) {
		Bean p = new Bean();
		p.setName(name);
		em.persist(p);
		em.flush();
		return p;
	}
}
