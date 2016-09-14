package com.xietian.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.gacl.domain.User;
import me.gacl.service.UserServiceI;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test demo = new test();
	}

	public test(){
		
		UserServiceI userService;
		
		  ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		  userService = (UserServiceI) ac.getBean("userService");
		  
		  User user = userService.getUserById("a");	  
		  System.out.println(user.getUserName());
	}
}
