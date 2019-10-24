package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.User;
@Mapper
public interface UserMapper {

	/**
	 * 注册
	 * @param user
	 */
	void insert(User user);

	List<User> listAll();

	List<User> selectById(int userId);

}
