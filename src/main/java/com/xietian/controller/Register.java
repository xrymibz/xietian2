package com.xietian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class Register {

	/**
	 * 
	 * ������һҳ
	 * @return
	 */
	@RequestMapping(value = "/back")
	public String main1() {
		return "login";
	}
	
	/**
	 * 
	 * �ύע����Ϣ
	 * 
	 */
	@RequestMapping("/commit")
	public String main2(HttpServletRequest request,Model model){
		
		String name=request.getParameter("userAccount");
		System.out.println("name :"  +name);
		//request.geta
		
		return "login";
	}
}
