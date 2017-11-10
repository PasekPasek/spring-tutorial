package com.timbuchalka.springdemo.serviceimpl;

import java.util.Random;

import com.timbuchalka.springdemo.service.BusinessService;

public class CloudService implements BusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization " + companyName + 
				" offers word class Cloud computing infrastructure."
				+ "\nThe annual income exceeds " + random.nextInt(revenue);
		return service;
	}
	
	public void postConstruct(){
		System.out.println("cloudService: postCnstuct called......");
	}
	
	public void preDestroy(){
		System.out.println("cloudService: preDestroy called......");
	}

}
