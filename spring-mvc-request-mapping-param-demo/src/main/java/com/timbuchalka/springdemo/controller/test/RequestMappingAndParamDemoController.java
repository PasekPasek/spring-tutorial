package com.timbuchalka.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//test2: testing @RequestMapping method attribute
	@RequestMapping(value="/test2", method= RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgname") String orgName, Model model){
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}
	
	//test3: testing @RequestMapping fall back feature
	@RequestMapping(value="*", method= RequestMethod.GET)
	public String requestMappingAndParamTest3(){
		return "fallback";
	}
	
	//test4: testing @RequestMapping defaultValue attrbute
	@RequestMapping(value="/test4")
	public String requestMappingAndParamTest4(@RequestParam(value="orgname", defaultValue="Anonymous Organization") String orgName, Model model){
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}
	
	//test5: testing @RequestParam without name or value
	@RequestMapping(value="/test5", method= RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}

//	// test6, subtest 1: testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
//		model.addAttribute("orgname", orgname);
//		model.addAttribute("testserial", "test6-subtest1");
//		return "requestMappingAndParamResults2";
//	}
	
	// test6, subtest 1: testing removal of @RequestMapping ambiguity with the same base URI but with a different parameter
	@RequestMapping(value = "/test6", params="orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	// // test6, subtest 2: testing @RequestMapping
	// @RequestMapping(value = "/test6")
	// public String requestMappingAndParamTest6Subtest2(@RequestParam String
	// empcount, Model model) {
	// model.addAttribute("orgname", empcount);
	// model.addAttribute("testserial", "test6-subtest2");
	// return "requestMappingAndParamResults2";
	// }

	// test6, subtest 2: testing @RequestMapping
	@RequestMapping(value = "/test6", params="empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}
}
