package com.spotify.controller;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spotify.entity.Playlist;
import com.spotify.entity.Song;
import com.spotify.service.PlaylistService;
import com.spotify.service.SpotifyService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SpotifyService spotifyService;
	
	@GetMapping("/createplaylists")
	public String play(Model model) {
		List<Song> songList=spotifyService.fetchAllSongs();
  	    model.addAttribute("songs",songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylists")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		
	    playlistService.addplay(playlist);
	    
	    List<Song> songs=playlist.getSongs();
	    
        for(Song song:songs) {
        	song.getPlaylists().add(playlist);
        	spotifyService.updateSong(song);
	
         }
		return "adminhome";
	}
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		
		boolean paymentstatus = true;
		if(paymentstatus) {
		List<Playlist> playlists=playlistService.fetchAllPlaylist();
		model.addAttribute("playlist",playlists );
		return "viewplaylist";
		}else {
			return "paymentform";
		}
		
	}
	
	

}
