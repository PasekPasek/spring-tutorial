package com.timbuchalka.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.timbuchalka.springdemo.domain.Organization;

public interface OrganizationDao {
	
	//set the data source that would be required to create the database
	public void setDataSource(DataSource ds);
	
	//Create a record in the organziation table
	public boolean create(Organization org);
	
	//Retrieve a single organization
	public Organization getOrganization(Integer id);
	
	//Retrieve all organizations from the table
	public List<Organization> getAllOrganizations();
	
	//Deete a specific organization form the table
	public boolean delete(Organization org);
	
	//Update an existing organization
	public boolean update (Organization org);
	
	public void cleanup();

}
