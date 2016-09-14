package com.xietian.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modelPO.UserVO;

import me.gacl.domain.User;
import me.gacl.service.UserServiceI;



@Controller
public class MyController {

	

	@RequestMapping(value="/add")
	public ModelAndView login2(){
		System.out.println("zzz");
		UserServiceI userService;

		  ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		  userService = (UserServiceI) ac.getBean("userService");
		  User user = userService.getUserById("b");	
		  UserVO userVO = user.toUserVO(null);
		  
		  ModelAndView modelAndView = new ModelAndView("add");
		  modelAndView.addObject("user", userVO);
	
	
		return modelAndView;
	}
	
}