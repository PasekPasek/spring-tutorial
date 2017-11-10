package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanFactoryApp {

	public static void main(String[] args) {
		//create the app contect
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization organization = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg2");
		
		//invoke the company slogan
		//organization.corporateSlogan();
		
		// print org details
		System.out.println(organization);
		System.out.println(org2);
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
