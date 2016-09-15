package me.gacl.dao;

import me.gacl.domain.Account;

public interface AccountMapper {

	/**
	 * 查询用户的账户密码
	 * @param account
	 * @return
	 */
	Account VerifyAccount(Account account);
	
	
	/**
	 * 查询用户注册帐号是否重复
	 * @param account
	 * @return
	 */
	Account VerifySameAccount(Account account);
	
	
	/**
	 * 添加用户的账户密码
	 * @param account
	 * @return
	 */
	int  InsertAccount(Account account);
}
