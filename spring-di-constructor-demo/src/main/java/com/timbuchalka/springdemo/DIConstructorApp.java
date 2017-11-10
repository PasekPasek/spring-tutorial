package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.HumanResourceDept;
import com.timbuchalka.springdemo.domain.Organization;


public class DIConstructorApp {

	public static void main(String[] args) {
		//create the app contect
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization organization = (Organization) ctx.getBean("myorg");
		
		//invoke the company slogan
		System.out.println(organization.corporateSlogan());
		
		// print org details
//		System.out.println(organization);
		HumanResourceDept hrdept = (HumanResourceDept)ctx.getBean("myhrdept");
		
		System.out.println(hrdept.hiringStatus(5500));
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
