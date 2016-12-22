package com.ss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.MobileUserDao;
import com.ss.model.User;
import com.ss.service.MobileUserService;
@Service
public class MobileUserServiceImpl implements MobileUserService {

	@Autowired
	private MobileUserDao mud;
	
	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		Map<String,String> m = new HashMap<String,String>();
		m.put("name", name);
		m.put("password", password);
		userList = mud.queryByParameters(m);
		if(userList.size() != 0  ){
			return userList.get(0);
		}
		return null;
	}

}
