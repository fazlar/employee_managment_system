package com.exam.controller.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Attendance;
import com.exam.model.Employee;
import com.exam.model.Salary;
import com.exam.model.UserInfo;
import com.exam.service.UserInfoService;
import com.exam.service.attendance.AttendanceService;

@Controller
public class UserHomeController {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	AttendanceService attendanceService;	
	@GetMapping(value = "/user-project")
	public ModelAndView MyProject() {
		return new ModelAndView("pages/user/project");
	}
	@GetMapping(value = "/user-salary")
	public ModelAndView mySalary() {
		
		return new ModelAndView("pages/user/mysalary");
	}
	@GetMapping(value = "/user-schedul")
	public ModelAndView mySchedul() {
		return new ModelAndView("pages/user/myschedul");
	}
	@GetMapping(value = "/user-timesheet")
	public ModelAndView timeSheet() {
		return new ModelAndView("pages/user/mytimesheet");
	}
	@GetMapping(value = "/applyleave")
	public ModelAndView applyLeave() {
		
		return new ModelAndView("pages/user/apply-leave");
	}
	@GetMapping(value = "/take-attendance/{username}")
	public ModelAndView attendance(@PathVariable String username) {
		  Map<String, Object> model = new HashMap<>();
		  
		  UserInfo userInfoEntity=userInfoService.loadUserByUsdeatailes(username);
		  model.put("userInfoEntity", userInfoEntity);

		 Date date = new Date();
		    String strDateFormat = "hh:mm:ss a";
		    
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    Date date1 = new Date();
		    Date end = new Date();
		    try {
				 date1  = dateFormat.parse("10:00:00 am");
				 end=dateFormat.parse("04:00:00 pm");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    DateTime fixedTimeStart = new DateTime(date1);
		    DateTime fixedTimeEnd = new DateTime(end);
		    DateTime currentTime = new DateTime(date);
           
           int hour=Hours.hoursBetween(fixedTimeStart,currentTime).getHours() % 24;
           int hourEnd=Hours.hoursBetween(fixedTimeEnd,currentTime).getHours() % 24;
		    if(hour < 20) {
		    	String startAttendance= dateFormat.format(date1);
			    String CurrentTime= dateFormat.format(date);
			    model.put("startAttendance", startAttendance);
			    model.put("CurrentTime", CurrentTime);
			    model.put("CurrentHour", hour);
			    
			return new ModelAndView("pages/user/attendance",model);
		    	
		    }else if (hourEnd < 8) {
		    	String startAttendance= dateFormat.format(end);
			    String CurrentTime= dateFormat.format(date);
			    model.put("startAttendance", startAttendance);
			    model.put("CurrentTime", CurrentTime);
			    model.put("CurrentHour", hourEnd);
			    return new ModelAndView("pages/user/attendance",model);
			}
		    
		    else {
		    	return new ModelAndView("pages/user/error-attendance",model);
		    }
			
		    
		    
	}
	@PostMapping("/stake-attendance")
    public ModelAndView crateProject(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		
		Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    Date date1 = new Date();
	    Date end = new Date();
	     Timer taketime= new Timer();
	    try {
			 date1  = dateFormat.parse("10:00:00 am");
			 end=dateFormat.parse("04:00:00 pm");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String empName=request.getParameter("fullname");
	    DateTime fixedTimeStart = new DateTime(date1);
	    DateTime currentTime = new DateTime(date);
	    int hour=Hours.hoursBetween(fixedTimeStart,currentTime).getHours() % 24;
	    Attendance attendance=new Attendance();
	    if (hour < 1) {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			attendance.setUserName(currentPrincipalName);
	    	attendance.setTime(  new Date());
	    	attendance.setDate(java.time.LocalDate.now());
	    	attendance.setEmpName(empName);
	    	attendance.setComment("ontime");
	    	attendance.setStatus("present");
	    	attendance=attendanceService.saveAttendance(attendance);
	    	System.out.println(attendance.getTime());
	    	List<Attendance> Attendance  = attendanceService.getAttendanceByUsername(currentPrincipalName, java.time.LocalDate.now());
	    	model.put("shoattendance", Attendance);
	    	return new ModelAndView("pages/user/attendance", model);
	    	
		}
	
	        else {
	        	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String currentPrincipalName = authentication.getName();
				attendance.setUserName(currentPrincipalName);
		    	attendance.setTime(new Date());
		    	attendance.setDate(java.time.LocalDate.now());
		    	attendance.setEmpName(empName);
		    	attendance.setComment("to-late");
		    	attendance.setStatus("present");
		    	attendance=attendanceService.saveAttendance(attendance);
		    	System.out.println(attendance.getTime());
		    	 DateTime currentTime2 = new DateTime(attendance.getTime());
		    	 System.out.println(currentTime2);
		    	List<Attendance> Attendance  = attendanceService.getAttendanceByUsername(currentPrincipalName, java.time.LocalDate.now());
		    	model.put("shoattendance", Attendance);
		    	return new ModelAndView("pages/user/attendance", model);
	        }

	     
   
    }
	@GetMapping("/show-attendance")
    public ModelAndView showAll() {
        Map<String, Object> model = new HashMap<>();
        List<Attendance> attendanceList  = attendanceService.getAll();
        model.put("attendanceList", attendanceList);
        return new ModelAndView("pages/attendance-list", model);
    }

}
