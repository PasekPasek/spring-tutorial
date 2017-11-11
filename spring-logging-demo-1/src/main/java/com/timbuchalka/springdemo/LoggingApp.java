package com.timbuchalka.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Component
public class LoggingApp {

	@Autowired
	private OrganizationDao dao;

	@Autowired
	private DaoUtils daoUtils;

	public void actioMethod() {
		
		
		// Create seed data
		daoUtils.createSeedData(dao);

		// List organizattions
		List<Organization> orgs = dao.getAllOrganizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);

		// Create a new organization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFaiure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.createOperation);

		// geta a single otganization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, "getOrganization");

		// Updating a slogan for a organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build ** awesome ** driving machines!");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFaiure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);

		// Delete the org
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFaiure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);

		// Cleanup
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanUpOperation);

	}

	public static void main(String[] args) {
		// Creating app context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		LoggingApp mainApp = ctx.getBean(LoggingApp.class);
		mainApp.actioMethod();

//		// Create the bean
//		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");

		// close the app context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
