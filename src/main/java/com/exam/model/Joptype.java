package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joptype {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String jobType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Override
	public String toString() {
		return "Joptype [id=" + id + ", jobType=" + jobType + "]";
	}
	
}
