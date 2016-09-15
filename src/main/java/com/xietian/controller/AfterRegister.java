package com.xietian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/afterRegister")
public class AfterRegister {

	@RequestMapping("/yes")
	public String main1() {

		

		return "register";
	}
	
	@RequestMapping("/no")
	public String main2() {

		

		return "login";
	}
	
}
