package com.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.UserInfo;
import com.exam.service.UserInfoService;

@RestController
public class LoginController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserInfoService userInfoService;

	@PostMapping("/register")
	public UserInfo register( @Valid UserInfo userInfo, BindingResult results) {

		if (!results.hasErrors()) {
			userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			return userInfoService.save(userInfo);
		}
		return null;

	}
	
	
	@GetMapping("/login")
	public ModelAndView login() {
		
		return new ModelAndView("login");

	}
	@GetMapping("/login-success")
	public ModelAndView loginSuccess() {
		Map<String, Object> model = new HashMap<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		List<GrantedAuthority> roles = (List<GrantedAuthority>) authentication.getAuthorities();
		if(roles.get(0).getAuthority().equalsIgnoreCase("admin")) {
			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
			model.put("user", userInfo);
			return new ModelAndView("index",model);
		}
		if(roles.get(0).getAuthority().equalsIgnoreCase("user")) {
			UserInfo userInfo=userInfoService.loadUserByUsdeatailes(currentPrincipalName);
			model.put("user", userInfo);
			return new ModelAndView("userHome",model);
		}
		
		return null;
		
	}

//	@GetMapping("/")
//	public String Home() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//		if (!(auth instanceof AnonymousAuthenticationToken)) {
//			String currentUserName = auth.getName();			
//			return currentUserName;
//		}
//		return null;
//	}

}
