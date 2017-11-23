package com.timbuchalka.springdemo.controller.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.timbuchalka.springdemo.domain.test.Visitor;
import com.timbuchalka.springdemo.domain.test.VisitorCount;
import com.timbuchalka.springdemo.domain.test.VisitorData;
import com.timbuchalka.springdemo.domain.test.VisitorService;

@Controller
@SessionAttributes(names={"visitordata","visitorcount"})
@RequestMapping("/visitorRegister")
public class SessionRequestAttributeDemoController {
	
	@Autowired
	public VisitorService visitorService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(SessionRequestAttributeDemoController.class);
	
	public ModelAndView home(){
		return new ModelAndView("sessionRequestAttributeHome", "visitorsStats", new VisitorData());
	}
	
	@ModelAttribute(name="visitordata")
	public VisitorData addVisitorData(){
		List<Visitor> visitors = new ArrayList<>();
		VisitorData vData = new VisitorData(null, null, visitors);
		return vData;
	}
	
	@ModelAttribute(name="visitorcount")
	public VisitorCount countVisitors(){
		return new VisitorCount(0);
	}
	
	@RequestMapping(value="/visitor", method=RequestMethod.POST)
	public String getVisitors(@ModelAttribute("visitor") VisitorData currentVisitor, HttpSession session, SessionStatus sessionStatus, HttpServletRequest request){
		VisitorData visitorDataFromSession = (VisitorData) session.getAttribute("visitordata");
		visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
		VisitorCount visitorCount = (VisitorCount) session.getAttribute("visitorcount");
		visitorService.updateCount(visitorCount);
		if(visitorCount.getCount() == 5){
			sessionStatus.setComplete();
		}
		//debug
		LOGGER.info(visitorDataFromSession.toString());
		if(request.getMethod().equalsIgnoreCase("POST")){
			LOGGER.info("This is Post request");
		} else {
			LOGGER.info("This is a GET request");
		}
		
		return "sessionRequestAttributeResult";
	}

}
