package com.example.demo.services;


import java.util.List;

import com.example.demo.entities.Song;

public interface SongService 
{

	 public String addsongs(Song song);
	 
	 public boolean songexists(String songname);
	 
	 public List<Song> viewsongs();

	public void updateSong(Song song);

	public Song searchSong(String songname);
	
}
