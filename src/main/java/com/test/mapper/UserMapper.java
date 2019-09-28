package com.test.mapper;

import java.util.List;

import com.test.bean.User;

public interface UserMapper {

	/**
	 * 注册
	 * @param user
	 */
	void insert(User user);

	List<User> listAll();

}
