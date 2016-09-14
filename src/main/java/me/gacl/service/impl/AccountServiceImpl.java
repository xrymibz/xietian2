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
		System.out.println(1);
		Object user = accountMapper.VerifyAccount(account);
		System.out.println(2);
		if(user!=null) return true;
		else return false;
	}

}
