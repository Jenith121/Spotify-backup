package com.spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spotify.entity.Song;
import com.spotify.entity.User;
import com.spotify.service.SpotifyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	SpotifyService spotifyService;
	
	@PostMapping(value="/register")
	
	public String userdata(@ModelAttribute User user) {
		boolean userExists = spotifyService.emailExists(user);
		
		if(userExists==false) {
			spotifyService.saveUser(user);
		}
		else {
			System.out.println("dublicate");
		}
		return "login";
		
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session,Model model) {

		
		if (spotifyService.validUser(email,password)==true) {
			session.setAttribute("email", email);
			
			String role= spotifyService.getRole(email);
			if(role.equals("admin")){
				return "adminhome";
				
			}else {
				User user=spotifyService.getUser(email);
				boolean userstatus=user.isPremium();
				List<Song> fetchAllSongs=spotifyService.fetchAllSongs();
				model.addAttribute("songs",fetchAllSongs);
				
				model.addAttribute("ispremium",userstatus);
				return "customer";
			}
			
		}else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
