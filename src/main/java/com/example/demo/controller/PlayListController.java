 package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PlayListController {
    @Autowired
	SongService songser;
    
    @Autowired
    PlayListService pserv;
	
	@GetMapping("/map-playList")
	public String createPlayList(Model model)
	{
		List<Song> vsong=songser.viewsongs();
	      model.addAttribute("song", vsong);
		
		return "createplaylist";
	}
	
	@PostMapping("/playlistDB")
	public String addPlaylist(@ModelAttribute PlayList playlist) 
	{
		pserv.addPlaylist(playlist);
		List<Song> songslist=playlist.getSong();
		 for(Song song : songslist)
		 {
			 song.getPlaylist().add(playlist);
			 songser.updateSong(song);
		 }
		return "playlistsuccess";
	}
	
	@GetMapping("/map-viewplayList")
	public String fetchPlaylist(Model model)
	{
		List<PlayList> plist=pserv.fetchplaylist();
		model.addAttribute("plistview", plist);
		return "viewplaylist";
	}
	
}
