package com.exam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TimeSheet {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	private String empName;
	private String userName;
	private String projectName;
	
	private Date date;
	private String workingTitle;
	private String status;
	
	private String workDescription;
	private String totalHour;
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
	public String getWorkingTitle() {
		return workingTitle;
	}
	public void setWorkingTitle(String workingTitle) {
		this.workingTitle = workingTitle;
	}
	public String getWorkDescription() {
		return workDescription;
	}
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	public String getTotalHour() {
		return totalHour;
	}
	public void setTotalHour(String totalHour) {
		this.totalHour = totalHour;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TimeSheet [id=" + id + ", empName=" + empName + ", userName=" + userName + ", projectName="
				+ projectName + ", date=" + date + ", workingTitle=" + workingTitle + ", status=" + status
				+ ", workDescription=" + workDescription + ", totalHour=" + totalHour + "]";
	}
	
	
}
