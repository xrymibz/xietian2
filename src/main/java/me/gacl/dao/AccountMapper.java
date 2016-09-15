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
	 * ��ѯ�û�ע���ʺ��Ƿ��ظ�
	 * @param account
	 * @return
	 */
	Account VerifySameAccount(Account account);
	
	
	/**
	 * ����û����˻�����
	 * @param account
	 * @return
	 */
	int  InsertAccount(Account account);
}
