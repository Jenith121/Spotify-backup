package com.spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spotify.entity.Song;
import com.spotify.service.SpotifyService;

@Controller
public class SongController {

	@Autowired
    SpotifyService spotifyService;
	
	@PostMapping("/addsong")
	
	public String postSong(@ModelAttribute Song song ) {
		String name=song.getName();
		boolean songexist=spotifyService.songExist(name);
         if(songexist==false) {
        		spotifyService.postSong(song);
         }
         else {
        	 System.out.println("duplicate");
         }
		return "adminhome";
				
	}
	
	@GetMapping("/playsong")
	public String playSong(Model model) {
		
		boolean paymentstatus = true;
		if(paymentstatus) {
		List<Song> songslist=spotifyService.fetchAllSongs();
		model.addAttribute("songs", songslist);
		return "viewsong";
		}else {
			return "pay";
		}
		
	}
	@GetMapping("/viewsong")
	public String viewsong(Model model) {
			List<Song> songslist=spotifyService.fetchAllSongs();
			model.addAttribute("songs", songslist);
			return "viewsong";
		
		
	}

	
	

	
	
}
