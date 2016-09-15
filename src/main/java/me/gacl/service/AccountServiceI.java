package me.gacl.service;

import me.gacl.domain.Account;

public interface AccountServiceI {

	/**
	 * 
	 * 查询登录账户密码是否正确
	 * @param user
	 * @return
	 */
	boolean VerifyAccount(Account user);
	
	
	/**
	 * 查询注册用户的帐号是否重复
	 */
	boolean VerifySameAccount(Account user);
	
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	boolean InsertAccount(Account user);
}
