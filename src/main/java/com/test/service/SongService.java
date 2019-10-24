package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Song;
import com.test.mapper.ClicksMapper;
import com.test.mapper.SongMapper;

@Service
public class SongService {

	@Autowired
	private SongMapper songMapper;

	@Autowired
	private ClicksMapper clicksMapper;

	public List<Song> hotDownload() {
		List<Song> songList = songMapper.getClick();
		List<Song> list = new ArrayList<>();
		for (Song song : songList) {
			Song songDisplayBeans = songMapper.getSongDisplay(song.getSongId());
			list.add(songDisplayBeans);
		}

		return list;
	}

	public List<Song> selectById(Integer songId) {
		List<Song> list = songMapper.getSongById(songId);
		return list;
	}    
	
	
	

	public List<Song> selectAll() {
		List<Song> list = songMapper.selectAll();
		return list;
	}

	public List<Song> hotSearch() {		
		List<Song> list = clicksMapper.getSongId();
		
		List<Song> songList = new ArrayList<>();
		for (Song song : list) {
			songList.add(songMapper.getSongDisplay(song.getSongId()));
		}
		return list;
	}

}
