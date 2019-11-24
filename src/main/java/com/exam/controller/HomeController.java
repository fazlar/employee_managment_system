package com.exam.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.jasperreports.SimpleReportExporter;
import com.exam.jasperreports.SimpleReportFiller;
import com.exam.model.CreatProject;
import com.exam.model.Depatrment;
import com.exam.model.Employee;
import com.exam.model.Joptype;
import com.exam.model.UserInfo;
import com.exam.service.DepartmentService;
import com.exam.service.EmployeeService;
import com.exam.service.UserInfoService;
import com.exam.service.jobtype.JobtypeService;
import com.exam.service.project.CreatProjectService;

@Controller
public class HomeController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	JobtypeService JobtypeService;
	@Autowired
	CreatProjectService creatProjectService;
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	SimpleReportFiller simpleReportFiller;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	JavaMailSender javaMailSender;
	

	@GetMapping(value = "/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@GetMapping(value = "/dashboard")
	public ModelAndView dashboard() {
		return new ModelAndView("pages/report");
	}
	@GetMapping(value = "/attendance-report")
	public ModelAndView attendanceReport() {
		return new ModelAndView("pages/report/attendance-report");
	}
	@GetMapping(value = "/report")
	public ModelAndView department_report() {
		return new ModelAndView("pages/report/department-report");
	}
	@GetMapping(value = "/salaryreport")
	public ModelAndView salary_report() {
		return new ModelAndView("pages/report/report");
	}

	@GetMapping(value = "/addemp")
	public ModelAndView register() {

		Map<String, Object> model = new HashMap<>();
		List<Depatrment> DepatrmentList = departmentService.getAll();
		model.put("depatrment", DepatrmentList);

		List<Joptype> JoptypeList = JobtypeService.getAll();
		model.put("Joptype", JoptypeList);

		return new ModelAndView("pages/addemp", model);
	}

	@GetMapping(value = "/creatrproject")
	public ModelAndView createProject() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> projectmanagerList = employeeService.getAllProjectManager();
		model.put("projectManager", projectmanagerList);
		return new ModelAndView("pages/addproject", model);
	}

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/addshedule")
	public ModelAndView createShedule() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> employeeList = employeeService.getAll();
		model.put("employee", employeeList);
		List<UserInfo> UserInfo = userInfoService.getAll();
		model.put("User", UserInfo);

		return new ModelAndView("pages/addshedule", model);
	}

	@GetMapping(value = "/createTimesheet")
	public ModelAndView createTimesheet() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> employeeList = employeeService.getAll();
		model.put("employee", employeeList);
		List<CreatProject> projectlist = creatProjectService.getAll();
		model.put("projectlist", projectlist);
		List<UserInfo> UserInfo = userInfoService.getAll();
		model.put("User", UserInfo);
		return new ModelAndView("pages/createtimesheet", model);
	}

	@GetMapping(value = "/paysalary")
	public ModelAndView paySalary() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> employeeList = employeeService.getAll();
		model.put("employee", employeeList);
		List<UserInfo> UserInfo = userInfoService.getAll();
		model.put("User", UserInfo);

		return new ModelAndView("pages/paysalary", model);
	}

	@GetMapping(value = "/department")
	public ModelAndView dePartment() {
		return new ModelAndView("pages/add-department");
	}
	@GetMapping(value = "/assignproject-report")
	public ModelAndView assignproject_report() {
		return new ModelAndView("pages/report/assignproject-report");
	}
	

	@GetMapping(value = "/assigenPrpject")
	public ModelAndView assigenPrpject() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> employeeList = employeeService.getEmpForProjec();
		model.put("employee", employeeList);
		List<CreatProject> projectlist = creatProjectService.getAll();
		model.put("projectlist", projectlist);
		List<UserInfo> UserInfo = userInfoService.getAll();
		model.put("User", UserInfo);
		return new ModelAndView("pages/project-assing", model);
	}

	@GetMapping(value = "/alldepart")
	public ModelAndView showAllDepart() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> adminatration = employeeService.getAllAdminDepart();
		model.put("adminatration", adminatration);
		List<Employee> web = employeeService.getAllWebDepart();
		model.put("webdeprt", web);
		List<Employee> database = employeeService.getAllDatabaseDepart();
		model.put("database", database);
		List<Employee> ntdepart = employeeService.getAllNtDepart();
		model.put("ntdepart", ntdepart);
		List<Employee> hrdepart = employeeService.getAllHRDepart();
		model.put("hrdepart", hrdepart);
		List<Employee> finance = employeeService.getAllFinanceDepart();
		model.put("finance", finance);
		return new ModelAndView("pages/department/all-department", model);
	}
	@GetMapping("/pdf")
	public String pdf(HttpServletResponse response) {
		response.setContentType("application/pdf");
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();

			simpleReportFiller.setReportFileName("report3.jrxml");
			simpleReportFiller.compileReport();

			Map<String, Object> parameters = new HashMap<>();

			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

			simpleExporter.exportToPdf("report3.pdf", "olonsoft");

			File file = new File("src/main/resources/reports/report3.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"report3.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/pdfbyusername")
	public String withParameter(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/pdf");
		String username = request.getParameter("username");
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();
			simpleReportFiller.setReportFileName("report4.jrxml");
			simpleReportFiller.compileReport();
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("username", username);
			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
			simpleExporter.exportToPdf("report4.pdf", "olonsoft");
			File file = new File("src/main/resources/reports/report4.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"report4.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping(value = "/mail")
	public ModelAndView emil() {
		return new ModelAndView("pages/mail");
	}
	@RequestMapping("/sendEmail")
    public ModelAndView sendEmail(@RequestParam("email") String email, @RequestParam("sub") String sub,
            @RequestParam("body") String body, Map<String, String> map) {
        
        SimpleMailMessage massage = new SimpleMailMessage();
        massage.setTo(email);
        massage.setSubject(sub);
        massage.setText(body);
        System.out.println("OKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
        javaMailSender.send(massage);
        map.put("massage", "Email Send SuccessFull");
        return new ModelAndView("pages/mail", map);
    }
	@GetMapping(value = "/all-emp")
	public ModelAndView allEmp() {
		Map<String, Object> model = new HashMap<>();
		List<Employee> employeeList = employeeService.getAll();
		model.put("employee", employeeList);
		return new ModelAndView("pages/employee-listPic",model);
	}
	@PostMapping("/pdfbyDepartment")
	public String pdfbyDepartment(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/pdf");
		String department = request.getParameter("department");
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();
			simpleReportFiller.setReportFileName("department.jrxml");
			simpleReportFiller.compileReport();
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("department", department);
			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
			simpleExporter.exportToPdf("department.pdf", "olonsoft");
			File file = new File("src/main/resources/reports/department.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"department.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * @PostMapping("/pdfbyAssigneproject") public String
	 * assigneproject(HttpServletRequest request, HttpServletResponse response) {
	 * response.setContentType("application/pdf"); String department =
	 * request.getParameter("department"); try { SimpleReportExporter simpleExporter
	 * = new SimpleReportExporter();
	 * simpleReportFiller.setReportFileName("assigneproject.jrxml");
	 * simpleReportFiller.compileReport(); Map<String, Object> parameters = new
	 * HashMap<>(); parameters.put("department", department);
	 * simpleReportFiller.setParameters(parameters);
	 * simpleReportFiller.fillReport();
	 * simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
	 * simpleExporter.exportToPdf("department.pdf", "olonsoft"); File file = new
	 * File("src/main/resources/reports/assigneproject.pdf");
	 * response.setHeader("Content-Type",
	 * servletContext.getMimeType(file.getName()));
	 * response.setHeader("Content-Length", String.valueOf(file.length()));
	 * response.setHeader("Content-Disposition",
	 * "inline; filename=\"assigneproject.pdf\""); Files.copy(file.toPath(),
	 * response.getOutputStream()); } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 */
	@GetMapping("/pdfbyAssigneproject")
	public String pdfbyAssigneproject(HttpServletResponse response) {
		response.setContentType("application/pdf");
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();

			simpleReportFiller.setReportFileName("assigneproject.jrxml");
			simpleReportFiller.compileReport();

			Map<String, Object> parameters = new HashMap<>();

			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

			simpleExporter.exportToPdf("assigneproject.pdf", "olonsoft");

			File file = new File("src/main/resources/reports/assigneproject.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"assigneproject.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/pdfbymonthlysalary")
	public String pdfbymonthlysalary(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/pdf");
		String month = request.getParameter("month");
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();
			simpleReportFiller.setReportFileName("monthlysalary.jrxml");
			simpleReportFiller.compileReport();
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("month", month);
			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
			simpleExporter.exportToPdf("monthlysalary.pdf", "olonsoft");
			File file = new File("src/main/resources/reports/monthlysalary.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"monthlysalary.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/pdfbyyearlysalary")
	public String pdfbyyearlysalary(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/pdf");
		String year = request.getParameter("year");
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();
			simpleReportFiller.setReportFileName("yearlysalary.jrxml");
			simpleReportFiller.compileReport();
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
			simpleExporter.exportToPdf("yearlysalary.pdf", "olonsoft");
			File file = new File("src/main/resources/reports/yearlysalary.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"yearlysalary.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/pdfbyattendance")
	public String pdfbyattendance(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/pdf");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = request.getParameter("date");
		Date date = null;
		try {
			date = sdf.parse(date1); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			SimpleReportExporter simpleExporter = new SimpleReportExporter();
			simpleReportFiller.setReportFileName("attendance.jrxml");
			simpleReportFiller.compileReport();
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("date", date);
			simpleReportFiller.setParameters(parameters);
			simpleReportFiller.fillReport();
			simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
			simpleExporter.exportToPdf("attendance.pdf", "olonsoft");
			File file = new File("src/main/resources/reports/attendance.pdf");
			response.setHeader("Content-Type", servletContext.getMimeType(file.getName()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"attendance.pdf\"");
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
