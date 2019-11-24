package com.exam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.CreatProject;
import com.exam.model.Employee;
import com.exam.model.Schedul;
import com.exam.model.UserInfo;
import com.exam.service.UserInfoService;
import com.exam.service.project.CreatProjectService;

@RestController
public class ProjectController {
	@Autowired
	CreatProjectService creatProjectService;
	@Autowired
	UserInfoService userInfoService;
	
	
	@PostMapping("/addproject")
    public ModelAndView crateProject(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String projectName=request.getParameter("projectName");
		String clientName=request.getParameter("clientName");
		String projectType=request.getParameter("projectType");
		String ProjectManager=request.getParameter("projectManager");
		String forntTech=request.getParameter("frontend");
		String databaseTech=request.getParameter("database");
		String desCripation=request.getParameter("description");
		String date=request.getParameter("date");
		
	     
		
		CreatProject creatProject=new CreatProject();
		creatProject.setProjectName(projectName);
		creatProject.setClientName(clientName);
		creatProject.setProjectType(projectType);
		creatProject.setProjectManager(ProjectManager);
		creatProject.setDatabaseTech(databaseTech);
		creatProject.setForntTech(forntTech);
		creatProject.setDesCripation(desCripation);
		Date creatproDate = null;
		try {
			creatproDate = sdf.parse(date); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		creatProject.setDate(creatproDate);
		
	     creatProject=creatProjectService.saveCreatProject(creatProject);
	     if (creatProject != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/addproject", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addproject", model);
	        }

	     
   
    }
	 @GetMapping("/show-project")
	    public ModelAndView showAllProject() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
	        Map<String, Object> model = new HashMap<>();
	       List<CreatProject> projectList  = creatProjectService.getAll();
	        model.put("projectList", projectList);
	       
			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
			model.put("user", userInfo);
	        return new ModelAndView("pages/show-project", model);
	    }
	 @GetMapping("/project/edit/{id}")
	    public ModelAndView edit(@PathVariable int id) {
	        Map<String, Object> model = new HashMap<>();
	        CreatProject creatProject = creatProjectService.getById(id);
	        model.put("CreatProject", creatProject);
	       // List<Employee> employeeList  = employeeService.getAll();
	       // model.put("employee", employeeList);
	       // List<UserInfo> UserInfo  = userInfoService.getAll();
	        //model.put("User", UserInfo);
	        
	        return new ModelAndView("pages/updateschudl", model);
	    }
	 @GetMapping("/project/delete/{id}")
	    public ModelAndView delete(@PathVariable int id) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
		 
	        Map<String, Object> model = new HashMap<>();
	        boolean deletepro=creatProjectService.delete(id);
	        if (deletepro) {
	        	model.put("success", true);
	            model.put("message", "delete Successful");
	        	 List<CreatProject> projectList  = creatProjectService.getAll();
	 	        model.put("projectList", projectList);
	 	      
	 			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
	 			model.put("user", userInfo);
	 	        return new ModelAndView("pages/show-project", model);
			}
	        else {
	            model.put("error", false);
	            model.put("message", "delete failed");
	            return new ModelAndView("pages/addproject", model);
	        }
	    
	    }
	 @PostMapping("/show-searchproject")
	    public ModelAndView searchProject(HttpServletRequest request) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			String serch=request.getParameter("serch");
	        Map<String, Object> model = new HashMap<>();
	       List<CreatProject> projectList  = creatProjectService.getSerch(serch);
	       System.out.println(projectList);
	       System.out.println(serch);
	        model.put("projectList", projectList);
			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
			model.put("user", userInfo);
	        return new ModelAndView("pages/show-project", model);
	    }
	 


}
