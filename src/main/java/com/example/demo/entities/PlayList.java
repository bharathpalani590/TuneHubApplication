package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class PlayList {
   @Id
   @GeneratedValue(strategy =GenerationType.AUTO)
   int playlistid;
   
   String playlistname;
   @ManyToMany
   List<Song> song;

public PlayList() {
	super();
}

public PlayList(int playlistid, String playlistname, List<Song> song) {
	super();
	this.playlistid = playlistid;
	this.playlistname = playlistname;
	this.song = song;
}

public int getPlaylistid() {
	return playlistid;
}

public void setPlaylistid(int playlistid) {
	this.playlistid = playlistid;
}

public String getPlaylistname() {
	return playlistname;
}

public void setPlaylistname(String playlistname) {
	this.playlistname = playlistname;
}

public List<Song> getSong() {
	return song;
}

public void setSong(List<Song> song) {
	this.song = song;
}

@Override
public String toString() {
	return "PlayList [playlistid=" + playlistid + ", playlistname=" + playlistname + ", song=" + song + "]";
}
    
   
}
