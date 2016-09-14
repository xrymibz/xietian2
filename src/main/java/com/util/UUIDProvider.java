package com.util;

import java.util.UUID;

public class UUIDProvider {

	 public static  String UUIDOffer(){
		   UUID uuid = UUID.randomUUID();
		   return uuid.toString();
	   }	    	
}
