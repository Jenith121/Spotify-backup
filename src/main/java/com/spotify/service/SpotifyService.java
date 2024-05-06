package com.spotify.service;



import java.util.List;
import java.util.jar.Attributes.Name;

import com.spotify.entity.Playlist;
import com.spotify.entity.Song;
import com.spotify.entity.User;

public interface SpotifyService {
	
	public void saveUser(User user);

 boolean emailExists(User user);

 boolean validUser(String email, String password);


public String getRole(String email);

 void postSong(Song song);

public boolean songExist(String name);

public List<Song> fetchAllSongs();


public void updateSong(Song song);

public User getUser(String mail);

public void updateUser(User user);


















}
