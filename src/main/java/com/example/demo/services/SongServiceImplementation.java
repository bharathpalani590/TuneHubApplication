package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepositories;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
     SongRepositories songrepo; 
	
	@Override
	public String addsongs(Song song) {
        songrepo.save(song);
		return "Song is added";
	}

	@Override
	public boolean songexists(String songname) 
	{
		if(songrepo.findBysongname(songname)==null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<Song> viewsongs() {
       List<Song> songlist=songrepo.findAll();
		return songlist;
	}

	@Override
	public void updateSong(Song song) {
         songrepo.save(song);		
	}

	@Override
	public Song searchSong(String songname) {
		Song res=songrepo.findBysongname(songname);
		return res;
	}

	

}
