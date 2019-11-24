package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Depatrment;
import com.exam.model.Joptype;
import com.exam.service.DepartmentService;
import com.exam.service.jobtype.JobtypeService;

@RestController
public class DepartmrntControler {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	JobtypeService JobtypeService;
	
	@PostMapping("/add-department")
    public ModelAndView userReg(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		String depName=request.getParameter("department");
		Depatrment depatrment=new Depatrment();
		depatrment.setDepName(depName);
		depatrment=departmentService.saveDepartment(depatrment);
	     if (depatrment != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/add-department", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addemp", model);
	        }
		
	}
	@PostMapping("/add-jobtype")
    public ModelAndView saveJobtyp(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		String depName=request.getParameter("jobtype");
		Joptype joptype=new Joptype();
		joptype.setJobType(depName);
		joptype=JobtypeService.saveJobtype(joptype);
	     if (joptype != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/add-department", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addemp", model);
	        }
		
	}
}
