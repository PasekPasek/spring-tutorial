package com.timbuchalka.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {

	public static void main(String[] args) {
		//Creating app context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//Create the bean
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		List<Organization> orgs = dao.getAllOrganizations();
		for(Organization org : orgs){
			System.out.println(org);
		}
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
