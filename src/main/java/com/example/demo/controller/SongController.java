package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {
	
    @Autowired
	SongService songser;
    
    @PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song)
	{
        boolean songstatus=songser.songexists(song.getSongname());
		if(songstatus==true)
		{
			songser.addsongs(song);
			return "songadded";
		}
		else
		{
			return "songexist";
		}
		
	}
			
		@GetMapping("/map-view")
		public String viewsongs(Model model) 
		{
		      List<Song> vsong=songser.viewsongs();
		      model.addAttribute("song", vsong);
				return "viewsong";
	    }		
		
		@GetMapping("/map-customerview")
		public String customerviewsong(Model model)
		{
			
			boolean viewstauts=true;
			if(viewstauts==true)
			{
				List<Song> vsong=songser.viewsongs();
			      model.addAttribute("song", vsong);
				return "customerviewsong";
			}
			else
			{
				return "makepayment";
			}
		}
		
		@GetMapping("/search")
		public String searchSongs(@RequestParam String songname,Model model) 
		{
		   Song song=songser.searchSong(songname);
		   model.addAttribute("song", song);
			if(song!=null)
			{
				return "Search";
			}
			else
			{
				return "viewsong";
			}
			
		}

		
		
		
	
}
