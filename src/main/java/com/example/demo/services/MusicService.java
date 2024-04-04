package com.example.demo.services;

import com.example.demo.entities.Music;

public interface MusicService {
	
	public String adduser(Music music);
	
	public boolean emailExists(String mail);
	
	public boolean validateUser(String mail,String password);
	
	public String role(String mail);

	public Music getUser(String mail);

	public void updateUser(Music mus);

}
