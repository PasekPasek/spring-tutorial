package com.timbuchalka.springdemo;

import java.beans.Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {

	public static void main(String[] args) {
		//create the app contect
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		//create the bean
		Organization organization = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan
		organization.corporateSlogan();
		
		//close the app context
		((FileSystemXmlApplicationContext) ctx).close();
	}

}
