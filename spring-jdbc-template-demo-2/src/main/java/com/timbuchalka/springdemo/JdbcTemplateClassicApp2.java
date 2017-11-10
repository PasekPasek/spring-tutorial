package com.timbuchalka.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

public class JdbcTemplateClassicApp2 {

	public static void main(String[] args) {
		//Creating app context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//Create the bean
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		
		//Create seed data
		DaoUtils.createSeedData(dao);
		
		//List organizattions
		List<Organization> orgs = dao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);
		
		//Create a new organization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		DaoUtils.printSuccessFaiure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.createOperation);
		
		//geta a single otganization
		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");
		
		//Updating a slogan for a organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build ** awesome ** driving machines!");
		boolean isUpdated = dao.update(org3);
		DaoUtils.printSuccessFaiure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(dao.getOrganization(2), DaoUtils.updateOperation);
		
		//Delete the org
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		DaoUtils.printSuccessFaiure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.deleteOperation);
		
		//Cleanup
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.cleanUpOperation);
		
		
		//close the app context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
