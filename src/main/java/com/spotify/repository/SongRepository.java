package com.spotify.repository;

import java.util.jar.Attributes.Name;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotify.entity.Playlist;
import com.spotify.entity.Song;
import com.spotify.entity.User;

public interface SongRepository extends JpaRepository<Song, Integer> {

	

	Song findByName(String name);



}
