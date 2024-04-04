package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Music;

public interface MusicRepositories extends JpaRepository<Music, Integer>{

	public Music findBymail(String mail);

}
