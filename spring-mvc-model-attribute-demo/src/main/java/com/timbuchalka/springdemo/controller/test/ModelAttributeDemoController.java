package com.timbuchalka.springdemo.controller.test;

import javax.management.Attribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timbuchalka.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);
	
	@RequestMapping(value="/home")
	public String home(){
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	
	//Test1: Demonstrting the usage of @ModelAttribute annotation (on a method)
	@ModelAttribute
	public void modelAttributeTest1(Model model){
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test bed!");
		model.addAttribute("testdata1B", "We will test both usages of the @ModelAttributes, on methods and on method arguments");
	}
	
	//test2: demonstarting the usage of the name attribute of the @ModelAttribute annotation (on method)
	@ModelAttribute(name="testdata2")
	public String modelAttributeTest2(){
		LOGGER.info("INSIDE modelAttribute2");
		return "We will conduct a series of test here";
	}
	
	//Test3: Demonstarting the usage  of the @ModelAttribute annotation (on a method) to implicity add an attribute.
	//by returning it and also demonstrating the usage of the 'value' attribute of the @ModelAttribute annotation (on a method).
	@ModelAttribute(value="testdata3")
	public Address modelAttributeTest3(){
		LOGGER.info("INSIDE modelAttributeTest3");
		return new Address("Adelaide", "5000");
	}
	
	//test4: Demonstrate the default naming strategy of the @ModelAttribute annottaion (on a method)
	@ModelAttribute
	public Address modelAttributeTest4(){
		LOGGER.info("INSIDE modelAttributeTest4");
		return new Address("Sydney", "2000");
	}
}
