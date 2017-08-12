package com.src.starters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String showHome()
	{
		
		return "home";
	}
    
	@RequestMapping("/login_form")
	public String showLogin()
	{
		return "login_form";
		
	}
	
}
