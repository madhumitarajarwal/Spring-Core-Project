package com.rays.bean;

public class Person {
	  private String login=null;
	   private String password=null;
	   
	   private Person() {
		   
	   }
	   private Person(String login,String password) {
		   this.login=login;
		   this.password=password;
	   }
	   
	
   public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
   
   
}
