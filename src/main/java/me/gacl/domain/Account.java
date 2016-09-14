package me.gacl.domain;

public class Account {

	private String id;
	private String account;
	private String pwd;
	private String name;
	private String email;
	
	
//	public Account(String account,String pwd){
//		this.account = account;
//		this.pwd = pwd;
//	}
//	public Account(String id,String account,String pwd){
//		this.id = id;
//		this.account = account;
//		this.pwd = pwd;
//	}
	
	public Account(String id,String account,String pwd,String name,String email){
		this.id =id;
		this.account =account;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	public Account(){
		
	}
	


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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
