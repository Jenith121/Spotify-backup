package com.spotify.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotify.entity.Playlist;
import com.spotify.entity.Song;
import com.spotify.repository.PlaylistRepository;
import com.spotify.service.PlaylistService;


@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplay(Playlist playlist) {
		// TODO Auto-generated method stub
		
		Playlist exiplaylist=playlistRepository.findByName(playlist.getName());
		if(exiplaylist==null) {
		playlistRepository.save(playlist);
		}else {
			System.out.println("playlist already exist");
		}
	}

	@Override
	public List<Playlist> fetchAllPlaylist() {
		List<Playlist> playlist=playlistRepository.findAll();
		return playlist;
	}

	

	

	

	
	

	

	

	

}
