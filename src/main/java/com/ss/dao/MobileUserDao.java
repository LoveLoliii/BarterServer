package com.ss.dao;

import java.util.List;
import java.util.Map;

import com.ss.model.User;

public interface MobileUserDao {

	List<User> queryByParameters(Map<String, String> m);

	User queryById(int i);

	List<User> queryAll();

}
