package com.rays.bean;

public class UserBean {
   private String name;

   private UserBean() {
	   
   }
   private UserBean(String name) {
	   this.name=name;
	   
   }
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   
}
