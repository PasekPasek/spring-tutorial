package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConstructorArgsApp {

	public static void main(String[] args) {
		//create the app contect
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization organization = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan
		organization.corporateSlogan();
		
		// print org details
		System.out.println(organization);
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
