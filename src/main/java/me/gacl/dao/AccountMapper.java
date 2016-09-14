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
	 * 添加用户的账户密码
	 * @param account
	 * @return
	 */
	boolean InsertAccount(Account account);
}
