package com.exam.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Employee;
import com.exam.service.EmployeeService;

@RestController
public class ControllerRest {
	@Autowired
	EmployeeService employeeService;
	
	
	
	
	
	@PostMapping("/addemployee")
    public ModelAndView userReg(HttpServletRequest request,@RequestParam("filename") MultipartFile[] files) {
		Map<String, Object> model = new HashMap<>();
		 String uploadDir ="F:\\rabbi\\rabbi_project\\employee-manageement-system\\src\\main\\resources\\static\\img\\empImage";
	        // ---------------------------------------------------
	        StringBuilder fileNames = new StringBuilder();
	        Path fileNameAndPath = null;
	        System.out.println(files);
	        try {
	            for (MultipartFile file : files) {
	                fileNameAndPath = Paths.get(uploadDir, file.getOriginalFilename());
	                fileNames.append(file.getOriginalFilename());
	                Files.write(fileNameAndPath, file.getBytes());
	                
	            }
	            System.out.println(fileNameAndPath);
	        } catch (IOException e) {
	        	model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addemp", model);
	            //model.put("msg", "YOU HAVENT CHOOSE ANY IMAGES");
	            
	        }
	        System.out.println("File name path -------------" + fileNames);
		
	        
	        
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String postcode=request.getParameter("postcode");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String dateofbirth=request.getParameter("date");
		String department=request.getParameter("department");
		String email=request.getParameter("email");
		String fullname=request.getParameter("firstname");
		String gender=request.getParameter("gender");
		String jobtype=request.getParameter("JobType");
		String mobileno=request.getParameter("mobileno");
		String adderss=request.getParameter("address");
		
		String salary=request.getParameter("salary");
	   request.setAttribute("empname", fullname);
	   request.setAttribute("email", email);
		
		//System.out.println(empImage);
		Employee employee=new Employee();
	     employee.setFullname(fullname);
	     employee.setCity(city);
	     employee.setDepartment(department);
	     employee.setCountry(country);
	     Date fCDate = null;
			try {
				fCDate = sdf.parse(dateofbirth); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	     employee.setDateofbirth(fCDate);
	     employee.setEmail(email);
	     employee.setAddress(adderss);
	     employee.setJobtype(jobtype);
	     employee.setGender(gender);
	     employee.setMobileno(mobileno);
	     employee.setSalary(salary);
	     employee.setEmpImage(fileNames.toString());
	     
	     employee.setPostCode(postcode);
	     employee=employeeService.saveEmployee(employee);
	     if (employee != null) {
	            model.put("success", true);
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/addemp", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/addemp", model);
	        }
	     
   
    }
	 @GetMapping("/show-employee")
	    public ModelAndView showAll() {
	        Map<String, Object> model = new HashMap<>();
	        List<Employee> employeeList  = employeeService.getAll();
	        model.put("employee", employeeList);
	        return new ModelAndView("pages/employee-list", model);
	    }

	 @GetMapping("/employee/edit/{id}")
	    public ModelAndView edit(@PathVariable int id) {
	        Map<String, Object> model = new HashMap<>();
	        Employee employee = employeeService.getById(id);
	        model.put("employeeEntity", employee);
	        return new ModelAndView("pages/updateemp", model);
	    }
	 @GetMapping("/user/delete/{id}")
	    public ModelAndView delete(@PathVariable int id, Map<String, Object> model) {
	       
	        boolean delet=employeeService.delete(id);
	        if (delet) {
	        	model.put("success", true);
	            model.put("message", "delete Successful");
	        	List<Employee> employeeList  = employeeService.getAll();
		        model.put("employee", employeeList);
		       return new ModelAndView("redirect:/show-employee ");
			}
	        else {
	            model.put("error", false);
	            model.put("message", "delete failed");
	            return new ModelAndView("redirect:/show-employee", model);
	        }
	        
	        
	    }
	 @PostMapping("/serche-all")
	    public ModelAndView serchAll(HttpServletRequest request) {
	        Map<String, Object> model = new HashMap<>();
	        String serch=request.getParameter("serch");
	        System.out.println(serch);
	        List<Employee> employeeList  = employeeService.getSerch(serch);
	        System.out.println(employeeList);
	        model.put("employee", employeeList);
	        return new ModelAndView("pages/employee-list", model);
	    }

}
