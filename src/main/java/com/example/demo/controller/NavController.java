package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {


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
	
	/*
	public String viewsong()
	{
		return "viewsong";
	}
	*/
}
