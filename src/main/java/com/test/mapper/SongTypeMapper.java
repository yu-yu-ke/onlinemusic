package com.test.mapper;

import java.util.List;

import com.test.bean.SongType;

public interface SongTypeMapper {

	/**
	 * 获取所有音乐类型
	 * @return
	 */
	List<SongType> listAll();

	
}
