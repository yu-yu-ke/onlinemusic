package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.SongType;
@Mapper
public interface SongTypeMapper {

	/**
	 * 获取所有音乐类型
	 * @return
	 */
	List<SongType> listAll();

	
}
