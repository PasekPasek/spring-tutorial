package com.timbuchalka.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value="/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);
	
	@RequestMapping(value="/home")
	public String home(){
		return "requestMappingAndParamHome";
	}
	
	//test1: Testing @requestParam without explicit attributes
	@RequestMapping(value="/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgname") String orgName, Model model){
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}
}
