package com.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userwebservice")
public class MobileUserController {
	
	@RequestMapping("uploadRedirect")
	public String uploadRedirect(){
		return "uploadFile";
	}
	
	
}
