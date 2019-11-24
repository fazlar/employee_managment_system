package com.exam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.exam.model.Schedul;
import com.exam.model.UserInfo;
import com.exam.service.EmployeeService;
import com.exam.service.UserInfoService;
import com.exam.service.schedule.SchedulService;

@RestController
public class ScheduleController {
      @Autowired
      SchedulService schedulService;
      @Autowired
  	UserInfoService userInfoService;
      @Autowired
  	EmployeeService employeeService;
	@PostMapping("/add-schedul")
    public ModelAndView userReg(HttpServletRequest request)  {
		Map<String, Object> model = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String empName=request.getParameter("employee");
		String clientName=request.getParameter("company");
		String userName = request.getParameter("username");
		String descripation=request.getParameter("description");
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		  
		//
		Schedul schedul=new Schedul();
		schedul.setEmpName(empName);
		schedul.setClientName(clientName);
		schedul.setDescripation(descripation);
		schedul.setUserName(userName);
		schedul.setTitle(title);
		schedul.setStatus("Incomplete");
		Date fCDate = null;
		try {
			fCDate = sdf.parse(date); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		schedul.setDate(fCDate);
		schedul = schedulService.saveSchedul(schedul);
	     if (schedul != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/addshedule", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addemp", model);
	        }
		
	}
	@GetMapping("/getschedul-byusername/{userName}")
	 public ModelAndView getSalaruByUserName(@PathVariable String userName) {
		Map<String, Object> model = new HashMap<>();
		 List<Schedul> schedulByUserName  = schedulService.getSalaryByUsername(userName);
	        model.put("schedulByUserName", schedulByUserName);
	        UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
 			model.put("user", userInfo);
	        return new ModelAndView("pages/user/myschedul",model);
	}
	@GetMapping("/show-schedul")
    public ModelAndView showAll() {
        Map<String, Object> model = new HashMap<>();
        List<Schedul> schedulList  = schedulService.getAll();
        model.put("schedulList", schedulList);
        return new ModelAndView("pages/show-schedul", model);
    }
	@GetMapping("/schedul/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Map<String, Object> model = new HashMap<>();
        Schedul schedul = schedulService.getById(id);
        model.put("schedul", schedul);
        List<Employee> employeeList  = employeeService.getAll();
        model.put("employee", employeeList);
        List<UserInfo> UserInfo  = userInfoService.getAll();
        model.put("User", UserInfo);
        return new ModelAndView("pages/updateschudl", model);
    }
 @GetMapping("/schedul/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        Map<String, Object> model = new HashMap<>();
        schedulService.delete(id);
        List<Schedul> schedulList  = schedulService.getAll();
        model.put("schedulList", schedulList);
        return new ModelAndView("pages/show-schedul", model);
    
    }
 @PostMapping("/serche-schedulinfo")
 public ModelAndView serchAll(HttpServletRequest request) {
     Map<String, Object> model = new HashMap<>();
     String serch=request.getParameter("serch");
     System.out.println(serch);
     List<Schedul> schedulList  = schedulService.getSerch(serch);
     System.out.println(schedulList);
     model.put("schedulList", schedulList);
     return new ModelAndView("pages/show-schedul", model);
 }
 @PostMapping("/searchmy-schedulinfo/{userName}")
 public ModelAndView searchmySchedulinfo(@PathVariable String userName,HttpServletRequest request) {
     Map<String, Object> model = new HashMap<>();
     String serch=request.getParameter("serch");
     System.out.println(serch);
     List<Schedul> schedulByUserName  = schedulService.getSerchMyschedul(userName,serch);
     System.out.println(schedulByUserName);
     System.out.println(userName);
     model.put("schedulByUserName", schedulByUserName);
     UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
		model.put("user", userInfo);
     return new ModelAndView("pages/user/myschedul", model);
 }
	
}
