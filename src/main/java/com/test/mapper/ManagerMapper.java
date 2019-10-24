package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.Manager;
@Mapper
public interface ManagerMapper {
	List<Manager> listAll();
}
