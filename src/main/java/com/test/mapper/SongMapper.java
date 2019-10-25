package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.Song;
@Mapper
public interface SongMapper {

	List<Song> getClick();

	Song getSongDisplay(Integer songId);

	Boolean update(Integer songId);

	List<Song> getSongById(Integer songId);

	List<Song> selectAll();

	Boolean downloadUpdate(Integer songId);

	List<Song> selectSongByTypeId(Integer typeId);
	
	
	
}
