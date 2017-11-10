package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;


public class CNamespaceApp {

	public static void main(String[] args) {
		//create the app contect
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization organization = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan
		
		// print org details
		System.out.println(organization);
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
