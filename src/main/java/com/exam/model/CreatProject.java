package com.exam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreatProject {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	private String projectName;
	private String clientName;
	private String projectType;
	private String projectManager;
	private String forntTech;
	private String databaseTech;
	private String desCripation;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getForntTech() {
		return forntTech;
	}
	public void setForntTech(String forntTech) {
		this.forntTech = forntTech;
	}
	public String getDatabaseTech() {
		return databaseTech;
	}
	public void setDatabaseTech(String databaseTech) {
		this.databaseTech = databaseTech;
	}
	public String getDesCripation() {
		return desCripation;
	}
	public void setDesCripation(String desCripation) {
		this.desCripation = desCripation;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CreatProject [id=" + id + ", projectName=" + projectName + ", clientName=" + clientName
				+ ", projectType=" + projectType + ", projectManager=" + projectManager + ", forntTech=" + forntTech
				+ ", databaseTech=" + databaseTech + ", desCripation=" + desCripation + ", date=" + date + "]";
	}
	
}
