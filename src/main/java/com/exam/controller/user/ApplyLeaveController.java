package com.exam.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.ApplyLeave;
import com.exam.model.AssignProject;
import com.exam.model.CreatProject;
import com.exam.model.Schedul;
import com.exam.service.leave.ApplyLeaveService;

@Controller
public class ApplyLeaveController {
	@Autowired
	ApplyLeaveService ApplyLeaveService;
	@PostMapping("/applyLeave")
    public ModelAndView crateProject(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String empName=request.getParameter("empname");
		String todate=request.getParameter("toDate");
		String descripation=request.getParameter("description");
		String reason=request.getParameter("reason");
		String fromdate=request.getParameter("fromdate");
		String userName=request.getParameter("userName");
		Date creatToDate = null;
		try {
			creatToDate = sdf.parse(todate); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date creatFromDate = null;
		try {
			creatFromDate = sdf.parse(fromdate); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ApplyLeave applyLeave= new ApplyLeave();
		
		applyLeave.setEmpName(empName);
		applyLeave.setReason(reason);
		applyLeave.setTodate(creatToDate);
		applyLeave.setFromdate(creatFromDate);
		applyLeave.setDescripation(descripation);
		applyLeave.setUserName(userName);
		applyLeave.setStatus("Pending");
		applyLeave=ApplyLeaveService.saveLeave(applyLeave);
	     if (applyLeave != null) {
	            model.put("success", true);
	            model.put("message", "Save Successful");
	            return new ModelAndView("pages/user/apply-leave", model);
	        }else {
	            model.put("error", false);
	            model.put("message", "Save failed");
	            return new ModelAndView("pages/user/apply-leave", model);
	        }

	     
   
    }
	@GetMapping("/show-leave")
    public ModelAndView showAll() {
        Map<String, Object> model = new HashMap<>();
        List<ApplyLeave> leaveList  = ApplyLeaveService.getAll();
        model.put("leaveList", leaveList);
        return new ModelAndView("pages/Approve-leave", model);
    }
	@GetMapping("/leave-update/{id}")
	public ModelAndView updatestatus(@PathVariable int id) {
		Map<String, Object> model = new HashMap<>();
		ApplyLeaveService.updateStatus(id);
		List<ApplyLeave> leaveList  = ApplyLeaveService.getAll();
        model.put("leaveList", leaveList);
		return new ModelAndView("pages/Approve-leave", model);
	}
	
}
