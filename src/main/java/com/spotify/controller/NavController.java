package com.spotify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController {
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	@GetMapping("/song")
	public String song() {
		return "song";
	}
	
	
	
	
	


}
