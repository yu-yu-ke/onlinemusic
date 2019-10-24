package com.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.User;
import com.test.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public Boolean register(String userName, String userPassword, Integer vipId, Date userBirthday, String userGender,
			Integer typeId) {

		User user = new User();

		// 数据封装
		user.setTypeId(typeId);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setVipId(vipId);
		user.setUserBirthday(userBirthday);
		user.setUserGender(userGender);
		try {
			userMapper.insert(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<User> listAll() {
		return userMapper.listAll();
	}

	public List<User> selectById(int userId) {
		return userMapper.selectById(userId);
	}

}
