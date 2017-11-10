package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;


public class BeanScopeApp {

	public static void main(String[] args) {
		//create the app contect
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization organization = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg");
		org2.setPostalCode("98989");
		
		//invoke the company slogan
//		System.out.println(organization.corporateSlogan());
		
		// print org details
		System.out.println(organization);
		System.out.println(org2);
		if(organization == org2){
			System.out.println("Singleton scope test - organization and org2 are poinitng to the same instance");
		} else{
			System.out.println("They are separate instances");
		}
		
		System.out.println(organization.corporateService());
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
