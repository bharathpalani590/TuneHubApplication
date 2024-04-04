package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NavController {
    
	@GetMapping("/home")
	public String homePage() 
	{
		return "home";
	}

	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "Register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String mapSongs()
	{
		return "addsongs";
	}
	
	@GetMapping("/payment")
	public String samplePayment()
	{
		return "samplepayment";
	}
	
	
	
	
}
