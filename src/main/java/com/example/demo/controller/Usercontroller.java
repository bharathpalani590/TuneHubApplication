package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Music;
import com.example.demo.services.MusicService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Usercontroller 
{
	@Autowired
	MusicService musser;
	
	
	
	@PostMapping("/register")
	public String adduser(@ModelAttribute Music music) 
	{
		
		boolean userstatus=musser.emailExists(music.getMail());
		if(userstatus==false)
		{
			 musser.adduser(music);
				return "registersucess";
		}
		
		else
		{
			return "registerfail";
		}
       
	 }
	
	@PostMapping("/loginController")
	public String validateUser(@RequestParam String mail,@RequestParam String password) 
	{
		boolean loginStatus=musser.validateUser(mail, password);
		
		if(loginStatus==true)
		{
			 String role=musser.role(mail);
			if(role.equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
			
		}
		else
		{
			return "loginfail";
		}
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(String mail) {
		Music music=musser.getUser(mail);
		
		boolean userStatus=music.isPremium();
		if(userStatus==true)
		{
			return "viewsong";
		}
		else
		{
			return "payment";
		}
}
	
	
	
	
}
