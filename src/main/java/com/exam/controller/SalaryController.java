package com.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Employee;
import com.exam.model.Salary;
import com.exam.model.TimeSheet;
import com.exam.model.UserInfo;
import com.exam.service.UserInfoService;
import com.exam.service.salary.SalaryService;

@RestController
public class SalaryController {
	@Autowired
	SalaryService salaryService;
	@Autowired
	UserInfoService userInfoService;
	
	
	@PostMapping("/savesalary")
    public ModelAndView crateProject(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		String empName=request.getParameter("empName");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String amount=request.getParameter("amount");
		String userName=request.getParameter("username");
		Salary salary=new Salary();
		salary.setEmpName(empName);
		salary.setMonth(month);
		salary.setYear(year);
		salary.setUserName(userName);
		salary.setAmount(Double.parseDouble(amount));
	     salary=salaryService.saveSalary(salary);
	     if (salary != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/paysalary", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addproject", model);
	        }

	     
   
    }
	@GetMapping("/getsalary-byusername/{userName}")
	 public ModelAndView getSalaruByUserName(@PathVariable String userName) {
		Map<String, Object> model = new HashMap<>();
		 List<Salary> salaruByUserName  = salaryService.getSalaryByUsername(userName);
		    
	        model.put("SalaruByUserName", salaruByUserName);
	      
			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
			model.put("user", userInfo);
	        return new ModelAndView("pages/user/mysalary",model);
	}
	@GetMapping("/show-salary")
    public ModelAndView showAllTmesheet() {
        Map<String, Object> model = new HashMap<>();
        List<Salary> salaryList  = salaryService.getAll();
        model.put("salaryList", salaryList);
        return new ModelAndView("pages/show-salary", model);
    }
	@PostMapping("/search-salary")
    public ModelAndView searchSalary(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        String serch=request.getParameter("serch");
        List<Salary> salaryList  = salaryService.getSerch(serch);
        model.put("salaryList", salaryList);
        return new ModelAndView("pages/show-salary", model);
    }
	@PostMapping("/search-byusername/{userName}")
	 public ModelAndView searchSalaruByUserName(@PathVariable String userName,HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		 String serch=request.getParameter("serch");
		 List<Salary> salaruByUserName  = salaryService.getSerchMySalary(userName, serch);
		    
	        model.put("SalaruByUserName", salaruByUserName);
	      
			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
			model.put("user", userInfo);
	        return new ModelAndView("pages/user/mysalary",model);
	}
}
