package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class AssignProject {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	private String empName;
	private String userName;
	private String projectName;
	
	private String status;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

   
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AssignProject [id=" + id + ", empName=" + empName + ", userName=" + userName + ", projectName="
				+ projectName + ", status=" + status + ", date=" + date + "]";
	}
	
	
}
