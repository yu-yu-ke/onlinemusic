package com.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Clicks;
import com.test.mapper.ClicksMapper;
import com.test.mapper.SongMapper;

@Service
public class ClicksService {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private SongMapper songMapper;

	@Autowired
	private ClicksMapper clicksMapper;

	public boolean click(Integer userId, Integer songId) {

		boolean songFlag = songMapper.update(songId);
		Clicks clicks = new Clicks();
		clicks.setUserId(userId);
		clicks.setSongId(songId);
		clicks.setClickDate(new Date());

		boolean clickFlag = clicksMapper.insert(clicks);
		boolean flag = false;
		if (songFlag && clickFlag) {
			flag = true;
		}
		return flag;
	}
	
	
	public boolean deleteById(int click_id) {
		boolean flag = clicksMapper.deleteById(click_id);
		return flag;
		
	}

}
