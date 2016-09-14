package com.util;




import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.gacl.service.UserServiceI;

public class SessionConnect {

	
	public static UserServiceI getConnect(String service){
		UserServiceI ServiceImp;
		
		  ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		  ServiceImp = (UserServiceI) ac.getBean(service);
		  
		  return ServiceImp;
	}
}
