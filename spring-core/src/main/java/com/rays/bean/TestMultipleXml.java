package com.rays.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultipleXml {
     public static void main(String[] args) {
    	 ApplicationContext context =new ClassPathXmlApplicationContext(new String[] {"User.xml","Person.xml"});
		 UserBean user=(UserBean)context.getBean("user");
		 Person person= (Person) context.getBean("person");
		 
		 System.out.println("person id " +person.getLogin());
	     System.out.println("person pas " +person.getPassword());
	     System.out.println("user name " +user.getName());
	}
}
