package me.gacl.domain;

public class Account {

	private String id;
	private String account;
	private String pwd;
	
	
//	public Account(String account,String pwd){
//		this.account = account;
//		this.pwd = pwd;
//	}
//	public Account(String id,String account,String pwd){
//		this.id = id;
//		this.account = account;
//		this.pwd = pwd;
//	}
	


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
