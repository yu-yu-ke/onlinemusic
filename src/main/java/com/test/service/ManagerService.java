package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Manager;
import com.test.mapper.ManagerMapper;

@Service
public class ManagerService {

	@Autowired
	private ManagerMapper managerMapper;
	
	public List<Manager> listAll() {
        return managerMapper.listAll();
    }

}
