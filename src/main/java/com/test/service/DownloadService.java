package com.test.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.DownLoad;
import com.test.mapper.DownloadMapper;
import com.test.mapper.SongMapper;

@Service
public class DownloadService {

	@Autowired
	private SongMapper songMapper;
	
	@Autowired
	private DownloadMapper downloadMapper;
	
	public Boolean download(Integer userId, Integer songId) {

        Boolean songFlag = songMapper.downloadUpdate(songId);
        
        DownLoad downLoad = new DownLoad();
        downLoad.setUserId(userId);
        downLoad.setSongId(songId);
        downLoad.setDownLoadDate(new Date()); 
        Boolean clickFlag = downloadMapper.insert(downLoad);

        Boolean flag = false;
        if (songFlag&&clickFlag){
            flag = true;
        }
        return flag;
    }

	
}
