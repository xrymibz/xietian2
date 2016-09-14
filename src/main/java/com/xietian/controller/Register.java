package com.xietian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.util.UUIDProvider;

import me.gacl.domain.Account;

@Controller
@RequestMapping("/register")
public class Register {

	/**
	 * 返回上一页
	 */
	@RequestMapping(value = "/back")
	public String main1() {
		return "login";
	}
	
	/**
	 * 提交注册信息
	 */
	@RequestMapping("/commit")
	public String main2(HttpServletRequest request,Model model){
		


		String uuid =UUIDProvider.UUIDOffer();
		String account = request.getParameter("userAccount");
		String pwd= request.getParameter("hashpwd");
		String name= request.getParameter("userName");
		String email= request.getParameter("userEmail");

		Account user = new Account(uuid,account,pwd,name,email);
		
		System.out.println(user.getId());
		System.out.println(user.getAccount());
		System.out.println(user.getPwd());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		return "login";
	}
}
