package org.sample.jpa.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETER")
@NamedQueries({ @NamedQuery(name = "Parameter.getByName", query = "SELECT o FROM Parameter o WHERE o.name LIKE :name") })
public class Parameter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@Column()
	private String name;

	@Column()
	private String valueString;

	@Column()
	private Date startDate;

	@Column()
	private Date endDate;

	public Parameter() {
	}

	public Parameter(long id, String name, String valueString) {
		this.id = id;
		this.name = name;
		this.valueString = valueString;
		this.startDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueString() {
		return valueString;
	}

	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
