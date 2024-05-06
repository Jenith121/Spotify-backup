package com.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spotify.entity.Song;
import com.spotify.entity.User;
@Repository
public interface SpotifyRepository extends JpaRepository<User,Integer> {

	User findByEmail(String email);

	void save(Song song);



	

	

	
}
