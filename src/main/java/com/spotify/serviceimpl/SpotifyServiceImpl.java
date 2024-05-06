package com.spotify.serviceimpl;



import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotify.entity.Playlist;
import com.spotify.entity.Song;
import com.spotify.entity.User;
import com.spotify.repository.SongRepository;
import com.spotify.repository.SpotifyRepository;
import com.spotify.service.SpotifyService;
@Service
public class SpotifyServiceImpl implements SpotifyService {
	@Autowired
	SpotifyRepository spotifyRepository;
	@Autowired
	SongRepository songRepository;
	
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		spotifyRepository.save(user);
	}

	@Override
	public boolean emailExists(User user) {
		 User existinguser = spotifyRepository.findByEmail(user.getEmail());
		 if(existinguser!=null) {
			 System.out.println("present");
			 return true;
		 }
		 else {
			 System.out.println("absent");
			 return false;
		 }
		
	}

	public boolean validUser(String email, String password) {
		// TODO Auto-generated method stub
		User user=spotifyRepository.findByEmail(email);
		String dppassword=user.getPassword();
		
		if(password.equals(dppassword)) {
			return true;
			
		}else {
			return false;
		}
		
	
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		User user=spotifyRepository.findByEmail(email);
		
		return user.getRole();
		
		
		
	}

	@Override
	public void postSong(Song song) {
		// TODO Auto-generated method stub
		spotifyRepository.save(song);
		
	}

	@Override
	public boolean songExist(String name) {
		Song song=songRepository.findByName( name);
		if(song != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<Song> fetchAllSongs() {
		List<Song> songs=songRepository.findAll();	
		return songs;
	}
	
	
	@Override
	public void updateSong(Song song) {
		spotifyRepository.save(song);
		
	}

	@Override
	public User getUser(String mail) {
		
		return spotifyRepository.findByEmail(mail);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		spotifyRepository.save(user);
		
	}

	
	

	
	

	

	

		

	

}
