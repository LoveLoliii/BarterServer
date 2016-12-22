package com.ss.dao.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ss.dao.MobileUserDao;
import com.ss.model.User;

public class MybatisTest {

	@Test
	public void test() {
		String res = "mybatis-config.xml";
		InputStream inputStream;
		
		
		try {
			inputStream = Resources.getResourceAsStream(res);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession ss = sf.openSession();
			
			MobileUserDao mud = ss.getMapper(MobileUserDao.class);
			User user  = mud.queryById(1);
			System.out.println(user);
			List<User> userList = mud.queryAll();
			for(User u:userList){
				System.out.println(u);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
