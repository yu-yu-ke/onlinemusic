package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.Clicks;
import com.test.bean.Song;

@Mapper
public interface ClicksMapper {

	Boolean insert(Clicks clicks);

	List<Song> getSongId();
	
	Boolean deleteById(int click_id);
}
