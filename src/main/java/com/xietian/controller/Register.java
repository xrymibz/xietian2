package com.xietian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.util.UUIDProvider;

import me.gacl.domain.Account;
import me.gacl.service.AccountServiceI;
import me.gacl.service.impl.AccountServiceImpl;

@Controller
@RequestMapping("/register")
public class Register {

	AccountServiceI accountService =null;
	
	
	
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
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" });
		accountService = (AccountServiceI) ac.getBean("AccountService");


		String uuid =UUIDProvider.UUIDOffer();
		String account = request.getParameter("userAccount");
		String pwd= request.getParameter("hashpwd");
		String name= request.getParameter("userName");
		String email= request.getParameter("userEmail");
		Account user = new Account(uuid,account,pwd,name,email);
		
//		System.out.println(user.getId());
//		System.out.println(user.getAccount());
//		System.out.println(user.getPwd());
//		System.out.println(user.getName());
//		System.out.println(user.getEmail());
		
		boolean isSame = accountService.VerifySameAccount(user);
		if(isSame){
	
			model.addAttribute("isSame", "yes");
			return "afterRegister";
		}
		
		else{
		accountService.InsertAccount(user);
		model.addAttribute("isSame", "no");
		return "afterRegister";
		}
	}
}
