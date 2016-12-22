package com.ss.dao.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ss.service.MobileUserService;

public class MobileUserDaoImpTest {

	@Autowired
	private MobileUserService mus;
	
	@Test
	public void test() {
	
		mus.login("1", "1");
		
	}

}
