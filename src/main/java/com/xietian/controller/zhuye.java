package com.xietian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class zhuye {

	@RequestMapping(value = "/")
	public String main1() {

	

		return "login";
	}
	
}
