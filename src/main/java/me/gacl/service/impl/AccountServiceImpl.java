package me.gacl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gacl.dao.AccountMapper;
import me.gacl.domain.Account;
import me.gacl.service.AccountServiceI;

@Service("AccountService")
public class AccountServiceImpl implements AccountServiceI{

	@Autowired
	AccountMapper accountMapper;
	
	public boolean VerifyAccount(Account account) {
		// TODO Auto-generated method stub
	
//		Account user = new Account(name,pwd);
	
		Object user = accountMapper.VerifyAccount(account);

		if(user!=null) return true;
		else return false;
	}
	


	public boolean InsertAccount(Account user) {

		int res = accountMapper.InsertAccount(user);
		

		 
		return false;
	}



	public boolean VerifySameAccount(Account account) {
		Object user = accountMapper.VerifySameAccount(account);

		if(user!=null) return true;
		else return false;
	}
}
