package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Depatrment {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String depName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Depatrment [id=" + id + ", depName=" + depName + "]";
	}
	
	
}
