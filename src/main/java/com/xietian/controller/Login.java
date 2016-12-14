package com.xietian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.gacl.domain.Account;
import me.gacl.service.AccountServiceI;

@Controller
@RequestMapping("/login")
public class Login {

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Model model) {
		AccountServiceI accountService;

		String account = request.getParameter("account");
		String pwd = request.getParameter("hashpwd");

		
		System.out.println("account  :"+account);
		System.out.println("pwd   :" +pwd);
//		if(account==null||account==""||pwd==""||pwd==null){
//			model.addAttribute("sign", "black");
//			return "login";
//		}
		
		Account user = new Account();
		user.setAccount(account);
		user.setPwd(pwd);


		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-mybatis.xml" });
		accountService = (AccountServiceI) ac.getBean("AccountService");

		boolean isOk = accountService.VerifyAccount(user);

		if (isOk) {
			System.out.println("ok");

			// return "add";
			return "redirect:/add";
		} else if(user.getAccount()!=null&&user.getPwd()!=null) {

			System.out.println("not ok");
			model.addAttribute("sign", "notPass");
			return "login";

		}
		return "login";
	}


	
	@RequestMapping(value = "register")
	public String main2() {

		

		return "register";
	}
	
}
