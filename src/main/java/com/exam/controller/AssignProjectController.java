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

import com.exam.model.AssignProject;
import com.exam.model.CreatProject;
import com.exam.model.Salary;
import com.exam.model.Schedul;
import com.exam.model.UserInfo;
import com.exam.service.UserInfoService;
import com.exam.service.assignProjectService.AssignProjectService;

@RestController
public class AssignProjectController {
	@Autowired
	AssignProjectService assignProjectService;
	@Autowired
	UserInfoService userInfoService;
	

	@PostMapping("/assigan-project")
	public ModelAndView userReg(HttpServletRequest request) throws ParseException {
		Map<String, Object> model = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String empName = request.getParameter("empName");
		String userName = request.getParameter("username");
		String projectName = request.getParameter("projectname");

		String date = request.getParameter("date");
		
		AssignProject assignProject = new AssignProject();
		assignProject.setEmpName(empName);
		assignProject.setUserName(userName);
		;
		assignProject.setProjectName(projectName);
		assignProject.setStatus("inComplete");
		Date assingDate = null;
		try {
			assingDate = sdf.parse(date); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assignProject.setDate(assingDate);

		assignProject = assignProjectService.saveAssignProject(assignProject);
		if (assignProject != null) {
			model.put("success", true);
			model.put("message", "Save Successful");
			return new ModelAndView("redirect:/assigenPrpject", model);
		} else {
			model.put("error", false);
			model.put("message", "Save failed");
			return new ModelAndView("pages/project-assing", model);
		}

	}

	@GetMapping("/getproject-byusername/{userName}")
	public ModelAndView getSalaruByUserName(@PathVariable String userName) {
		Map<String, Object> model = new HashMap<>();
		List<AssignProject> assignProjectByUserName = assignProjectService.getProjectByUsername(userName);
		model.put("assignProjectByUserName", assignProjectByUserName);
		UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
		model.put("user", userInfo);
		System.out.println(assignProjectByUserName.size());
		return new ModelAndView("pages/user/project", model);
	}

	@GetMapping("/getproject-update/{id}/{userName}")
	public ModelAndView updatestatus(@PathVariable int id, @PathVariable String userName) {
		Map<String, Object> model = new HashMap<>();
		assignProjectService.updateStatus(id);
		List<AssignProject> assignProjectByUserName = assignProjectService.getProjectByUsername(userName);
		System.out.println(assignProjectByUserName);
		model.put("assignProjectByUserName", assignProjectByUserName);
		UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
		model.put("user", userInfo);
		return new ModelAndView("pages/user/project", model);
	}
	@GetMapping("/show-assignproject")
    public ModelAndView showAllAssignProject() {
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
        Map<String, Object> model = new HashMap<>();
       List<AssignProject> projectList  = assignProjectService.getAll();
        model.put("projectList", projectList);
       
		UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
		model.put("user", userInfo);
        return new ModelAndView("pages/show-assiganproject", model);
    }
	@PostMapping("/search-assignproject")
    public ModelAndView showSearchAssignProject(HttpServletRequest request) {
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		String serch=request.getParameter("serch");
        Map<String, Object> model = new HashMap<>();
       List<AssignProject> projectList  = assignProjectService.getSerch(serch);
        model.put("projectList", projectList);
       
		UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
		model.put("user", userInfo);
        return new ModelAndView("pages/show-assiganproject", model);
    }
	@PostMapping("/searchproject-byusername/{userName}")
	public ModelAndView searchMyproject(@PathVariable String userName,HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		String serch=request.getParameter("serch");
		List<AssignProject> assignProjectByUserName = assignProjectService.getSerchMyschedul(userName, serch);
		model.put("assignProjectByUserName", assignProjectByUserName);
		UserInfo userInfo=userInfoService.loadUserByUsdeatailes(userName);
		model.put("user", userInfo);
		System.out.println(assignProjectByUserName.size());
		return new ModelAndView("pages/user/project", model);
	}

}
