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

import com.exam.model.AssignProject;
import com.exam.model.Employee;
import com.exam.model.Schedul;
import com.exam.model.TimeSheet;
import com.exam.model.UserInfo;
import com.exam.service.UserInfoService;
import com.exam.service.timesheet.TimeSheetService;
@RestController
public class TimeSheetController {
	@Autowired
	TimeSheetService timeSheetService;
	@Autowired
	UserInfoService userInfoService;
	@PostMapping("/add-timesheet")
    public ModelAndView userReg(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String empName=request.getParameter("empName");
		String projectName=request.getParameter("projectName");
		String date=request.getParameter("date");
		String workingTitle=request.getParameter("wtitle");
		String workDescription=request.getParameter("description");
		String totalHour=request.getParameter("hour");
		String username=request.getParameter("username");
		
		TimeSheet timeSheet=new TimeSheet();
		timeSheet.setEmpName(empName);
		Date timeSheetdate = null;
		try {
			timeSheetdate = sdf.parse(date); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeSheet.setUserName(username);
		timeSheet.setDate(timeSheetdate);
		timeSheet.setProjectName(projectName);
		timeSheet.setTotalHour(totalHour);
		timeSheet.setWorkDescription(workDescription);
		timeSheet.setWorkingTitle(workingTitle);
		timeSheet.setStatus("Incomplete");
		timeSheet=timeSheetService.saveTimeSheet(timeSheet);
	     if (timeSheet != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/createtimesheet", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/createtimesheet", model);
	        }

	     
   
    }
	 @GetMapping("/show-timesheet")
	    public ModelAndView showAllTmesheet() {
	        Map<String, Object> model = new HashMap<>();
	        List<TimeSheet> timeSheetList  = timeSheetService.getAll();
	        model.put("timeSheetList", timeSheetList);
	        return new ModelAndView("pages/show-timesheet", model);
	    }
	 @GetMapping("/gettimeSheet-byusername/{userName}")
	 public ModelAndView getSalaruByUserName(@PathVariable String userName) {
		Map<String, Object> model = new HashMap<>();
		 List<TimeSheet> timeSheetByUserName  = timeSheetService.getTimesheetByUsername(userName);
	        model.put("timeSheetByUserName", timeSheetByUserName);
	        UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
 			model.put("user", userInfo);
	        return new ModelAndView("pages/user/mytimesheet",model);
	}
	 @GetMapping("/timeSheet/delete/{id}")
	    public ModelAndView delete(@PathVariable int id, Map<String, Object> model) {
	       
	        boolean delet=timeSheetService.delete(id);
	        if (delet) {
	        	model.put("success", true);
	            model.put("message", "delete Successful");
	        	List<TimeSheet> timeSheetList  = timeSheetService.getAll();
		        model.put("timeSheetList", timeSheetList);
		       return new ModelAndView("redirect:/show-timesheet ");
			}
	        else {
	            model.put("error", false);
	            model.put("message", "delete failed");
	            return new ModelAndView("redirect:/show-timesheet", model);
	        }
	        
	        
	    }
	 @GetMapping("/gettimesheet-update/{id}/{userName}")
		public ModelAndView updatestatus(@PathVariable int id, @PathVariable String userName) {
			Map<String, Object> model = new HashMap<>();
			timeSheetService.updateStatus(id);
		/*
		 * List<AssignProject> assignProjectByUserName =
		 * assignProjectService.getProjectByUsername(userName);
		 * System.out.println(assignProjectByUserName);
		 * model.put("assignProjectByUserName", assignProjectByUserName); UserInfo
		 * userInfo=userInfoService.loadUserByUsdeatailes(userName); model.put("user",
		 * userInfo);
		 */
			return new ModelAndView("redirect:/gettimeSheet-byusername/{userName}", model);
		}
	 @PostMapping("/searchTmesheet")
	    public ModelAndView searchTmesheet(HttpServletRequest request) {
	        Map<String, Object> model = new HashMap<>();
	        String serch=request.getParameter("serch");
	        List<TimeSheet> timeSheetList  = timeSheetService.getSerch(serch);
	        model.put("timeSheetList", timeSheetList);
	        return new ModelAndView("pages/show-timesheet", model);
	    }
	 @PostMapping("/SearchMytimeshet/{userName}")
	 public ModelAndView getSearchMytimeshet(@PathVariable String userName,HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		 String serch=request.getParameter("serch");
		 List<TimeSheet> timeSheetByUserName  = timeSheetService.getSerchMyschedul(userName, serch);
	        model.put("timeSheetByUserName", timeSheetByUserName);
	        UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
 			model.put("user", userInfo);
	        return new ModelAndView("pages/user/mytimesheet",model);
	}

}
