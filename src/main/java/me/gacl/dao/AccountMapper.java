package me.gacl.dao;

import me.gacl.domain.Account;

public interface AccountMapper {

	/**
	 * ��ѯ�û����˻�����
	 * @param account
	 * @return
	 */
	Account VerifyAccount(Account account);
	
	
	/**
	 * ����û����˻�����
	 * @param account
	 * @return
	 */
	boolean InsertAccount(Account account);
}
