package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Song;
import com.test.bean.SongType;
import com.test.mapper.SongTypeMapper;

@Service
public class SongTypeService {

	@Autowired
	private SongTypeMapper songTypeMapper;
	
	public List<SongType> listAll() {
		
		List<SongType> listSongTypes = songTypeMapper.listAll();
		
		return listSongTypes;
	}

}
