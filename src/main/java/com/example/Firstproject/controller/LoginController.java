package com.example.Firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Firstproject.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	// Model is used to pass data from controller to view
	
//	@Autowired
//	LoginService service;
	
	
// @RequestMapping(value = "/login", method = RequestMethod.GET) // all type of request methods if not specified
// public String showLogin(ModelMap model) {
//	 return "login";
// }
 
 @RequestMapping(value = "/", method = RequestMethod.GET) // all type of request methods if not specified
 public String showLogin(ModelMap model) {
	 model.put("name", getLoggedinUserName()); //hardcoding
	 return "welcome";
 }
 
 private String getLoggedinUserName() {
	
	 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	if(principal instanceof UserDetails) {
		return ((UserDetails)principal).getUsername();
	}
	
	return principal.toString();
 }
// @RequestMapping(value = "/login", method = RequestMethod.POST) // all type of request methods if not specified
// public String showWelcomePage(@RequestParam String name,@RequestParam String pswd,ModelMap model) {
//	 boolean isValid = service.validateUser(name, pswd);
//	 if(!isValid) {
//		 model.put("errorMessage", "Invalid Credentials");
//		 return "login";
//	 }
//	 model.put("name", name);
//	 model.put("pswd", pswd);
//	 return "welcome";
// }
 
 
}



