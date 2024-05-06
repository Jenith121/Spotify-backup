package com.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spotify.entity.Playlist;


@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	Playlist findByName(String name);
	

}
