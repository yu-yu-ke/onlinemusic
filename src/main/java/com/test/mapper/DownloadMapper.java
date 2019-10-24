package com.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.DownLoad;

@Mapper
public interface DownloadMapper {

	public Boolean insert(DownLoad downLoad);

}
