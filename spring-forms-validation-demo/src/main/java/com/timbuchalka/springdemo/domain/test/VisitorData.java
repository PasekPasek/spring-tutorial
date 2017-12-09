package com.timbuchalka.springdemo.domain.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitorData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8104768195975645615L;

	private String currentVisitorName;
	private String currentVisitorEmail;
	private List<Visitor> visitors = new ArrayList<>();
	
	public VisitorData(String currentVisitorName, String currentVisitorEmail, List<Visitor> visitors) {
		this.currentVisitorName = currentVisitorName;
		this.currentVisitorEmail = currentVisitorEmail;
		this.visitors = visitors;
	}

	public VisitorData() {
		// TODO Auto-generated constructor stub
	}

	

	public String getCurrentVisitorName() {
		return currentVisitorName;
	}

	public void setCurrentVisitorName(String currentVisitorName) {
		this.currentVisitorName = currentVisitorName;
	}

	public String getCurrentVisitorEmail() {
		return currentVisitorEmail;
	}

	public void setCurrentVisitorEmail(String currentVisitorEmail) {
		this.currentVisitorEmail = currentVisitorEmail;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

	@Override
	public String toString() {
		return "Data [currentVisitorName=" + currentVisitorName + ", currentVisitorEmail=" + currentVisitorEmail
				+ ", visitors=" + visitors + "]";
	}	
}
