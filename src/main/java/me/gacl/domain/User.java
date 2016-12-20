package me.gacl.domain;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.modelPO.UserVO;

public class User {
    private String userId;

    private String userName;

    private Date userBirthday;

    private Double userSalary;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }
    
   public  UserVO toUserVO(UserVO user){
    	if(user==null){
    		user = new UserVO();
    	}
    	if(getUserName()!=null){
    		user.setName(getUserName());
    	}
    	if(getUserBirthday()!=null){
    		
    		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    		user.setBirthday(SDF.format(getUserBirthday()));
    	}
    	if(getUserSalary()!=null){
    		user.setSalary(getUserSalary());
    	}
		return user;
    }
}