package com.ss.controller.webservice;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ss.model.User;
import com.ss.service.MobileUserService;
@Controller
@RequestMapping("userwebservice")
public class MobileUserWebService {

	@Autowired
	private MobileUserService mus;
	
	@ResponseBody
	@RequestMapping("login")
	public User login(String mName,String mPassword){
		User u = mus.login(mName,mPassword);
		if(u != null){/*http://localhost:8888/AndroidLogin/userwebservice/login?mName=loveloliii&mPassword=loveloliii
*/			return u;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("upload")
	public String regist(@RequestParam String name,@RequestParam("head") MultipartFile file,HttpServletRequest request){
		//文件保存的时候,一定要知道文件决定路径
		String path =request.getServletContext().getRealPath("WEB-INF/upload");
		System.out.println(path);
		File uploadFile = new File(path,file.getOriginalFilename());
		System.out.println(uploadFile);
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//userService.addUser(user);
		return "success";
		//1.配置上传文件的处理器  multipartResolver 
		//2.编写表单:post enctyp
		//3.编写表单的action  参数 :表单的字段名/对象   MultipartFile  httpservletrequest(自动注入)
		//4.添加commons upload 处理上传文件的程序  jar
	}
	
	
	
}
