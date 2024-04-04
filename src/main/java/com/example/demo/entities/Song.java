package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
     String songname;
     String songartist;
     String songgenre;
     String songlink;
     
     @ManyToMany
     List<PlayList> playlist;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(int id, String songname, String songartist, String songgenre, String songlink,
			List<PlayList> playlist) {
		super();
		this.id = id;
		this.songname = songname;
		this.songartist = songartist;
		this.songgenre = songgenre;
		this.songlink = songlink;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getSongartist() {
		return songartist;
	}

	public void setSongartist(String songartist) {
		this.songartist = songartist;
	}

	public String getSonggenre() {
		return songgenre;
	}

	public void setSonggenre(String songgenre) {
		this.songgenre = songgenre;
	}

	public String getSonglink() {
		return songlink;
	}

	public void setSonglink(String songlink) {
		this.songlink = songlink;
	}

	public List<PlayList> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songname=" + songname + ", songartist=" + songartist + ", songgenre=" + songgenre
				+ ", songlink=" + songlink + "]";
	}

	
     
     
     

}
