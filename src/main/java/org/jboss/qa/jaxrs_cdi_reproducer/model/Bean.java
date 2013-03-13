package org.jboss.qa.jaxrs_cdi_reproducer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = Bean.FIND_ALL, query = "SELECT x from Bean x"),
		@NamedQuery(name = Bean.FIND_BY_ID, query = "SELECT x from Bean x WHERE x.id = :"
				+ Bean.NQ_ID) })
public class Bean implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Bean.findAll";
	public static final String FIND_BY_ID = "Bean.findById";
	public static final String NQ_ID = "beanId";

	@Id
	@SequenceGenerator(name = "BEAN_ID_GENERATOR", sequenceName = "BEAN_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEAN_ID_GENERATOR")
	private Integer id;

	private String name;

	public Bean() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}