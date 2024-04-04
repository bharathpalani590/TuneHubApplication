package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Music;
import com.example.demo.repositories.MusicRepositories;
@Service
public class ServiceImplementation implements MusicService{
	
	@Autowired
	MusicRepositories musrepo;

	@Override
	public String adduser(Music music) {
         musrepo.save(music);
		return "user is Created and Saved";
	}

	@Override
	public boolean emailExists(String mail) 
	{
		if(musrepo.findBymail(mail)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateUser(String mail, String password) {
		Music music=musrepo.findBymail(mail);
		String db_password=music.getPassword();
		
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String role(String mail) {
		Music music=musrepo.findBymail(mail);
		String db_role=music.getRole();
		return db_role;
		 //return (musrepo.findBymail(mail).getMail());
	}

	@Override
	public Music getUser(String mail) {
		
		return musrepo.findBymail(mail);
	}

	@Override
	public void updateUser(Music mus) {
     musrepo.save(mus);	
	}
	
	

}
