package me.gacl.service;

import me.gacl.domain.Account;

public interface AccountServiceI {

	/**
	 * 
	 * ��ѯ��¼�˻������Ƿ���ȷ
	 * @param user
	 * @return
	 */
	boolean VerifyAccount(Account user);
	
	
	/**
	 * ��ѯע���û����ʺ��Ƿ��ظ�
	 */
	boolean VerifySameAccount(Account user);
	
	
	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	boolean InsertAccount(Account user);
}
