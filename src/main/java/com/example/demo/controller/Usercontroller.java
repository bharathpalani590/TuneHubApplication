package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Music;
import com.example.demo.entities.Song;
import com.example.demo.services.MusicService;
import com.example.demo.services.SongService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Usercontroller {
	@Autowired
	MusicService musser;
	
	@Autowired 
	SongService songser;

	@PostMapping("/register")
	public String adduser(@ModelAttribute Music music) {

		boolean userstatus = musser.emailExists(music.getMail());
		if (userstatus == false) {
			musser.adduser(music);
			return "registersucess";
		}

		else {
			return "registerfail";
		}

	}

	@PostMapping("/loginController")
	public String validateUser(@RequestParam String mail, @RequestParam String password,HttpSession session) {
		boolean loginStatus = musser.validateUser(mail, password);

		if (loginStatus == true) {
			session.setAttribute("mail", mail);
			String role = musser.role(mail);
			if (role.equals("admin")) {
				return "adminhome";
			}
			else {
				return "customerhome";
			}

		} else {
			return "loginfail";
		}
	}

	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model) {
		String mail=(String) session.getAttribute("mail");
		Music music = musser.getUser(mail);

		boolean userStatus = music.isPremium();
		if (userStatus == true) {
			List<Song> vsong=songser.viewsongs();
		      model.addAttribute("song", vsong);
			return "viewsong";
		} else {
			return "samplepayment";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
         HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            return "login"; 
        }
        return "login";
    }
	
	

}
