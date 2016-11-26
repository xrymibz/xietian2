package com.xietian.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modelPO.UserVO;

import me.gacl.domain.User;
import me.gacl.service.UserServiceI;



@Controller
public class MyController {

	int totalPage =0;  //總的頁面數
	int currentPage = 0; //当前页面
	int pageSize = 3;  //每页条数
	int totalNum = 0; //总的数据数量
	int startNum = 0; //开始的数据序号
	int nextPage = 0;  //下一页
	int previousPage = 0; //上一页
	  
	boolean hasNextPage = false; //是否有下一页
	boolean hasPreviousPage = false; //是否有上一页	
	

	@RequestMapping(value="/add")
	public ModelAndView login2(HttpServletRequest request, Model model){
	

		System.out.println(currentPage);
		UserServiceI userService;

		  ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		  userService = (UserServiceI) ac.getBean("userService");
		  User user = userService.getUserById("b");	
		  UserVO userVO = user.toUserVO(null);
		  
		
		  List<User> nice = userService.QueryAllUser();
		  List<UserVO> nice2 = new ArrayList<UserVO>();
		  for(User i:nice){
			  nice2.add(i.toUserVO(null));
		  }
		totalNum = nice2.size();
		totalPage = (totalNum%pageSize==0)?totalNum/pageSize:totalNum/pageSize+1;
		
		String currentPages = request.getParameter("currentPages");
		if(currentPages!=null){
		currentPage = Integer.parseInt(currentPages);
		}
		if((currentPage+1)*pageSize>totalNum){
			currentPage--;
		}
		  
		  ModelAndView modelAndView = new ModelAndView("add");
		  modelAndView.addObject("user", userVO);
		  modelAndView.addObject("userAll", nice2);
		  modelAndView.addObject("totalNum", totalNum);
		  modelAndView.addObject("totalPage", totalPage);
		  modelAndView.addObject("pageSize", pageSize);
		  modelAndView.addObject("currentPage", currentPage);
		  
	
		return modelAndView;
	}
	
}
