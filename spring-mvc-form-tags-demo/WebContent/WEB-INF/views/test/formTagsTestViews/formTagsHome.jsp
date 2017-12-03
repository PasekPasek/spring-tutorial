<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/test-main.css" var="testMainCSS" />
<link href="${testMainCSS}" rel="stylesheet">
<title>Test bed</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to the Form tags test bed</h1>
		<hr>
		<h3>Register our organiztaion with us!</h3>
		<form:form action="registerOrg" modelAttribute="orgRegistration">
			<table>
				<tr>
					<td><form:label path="orgName">Name of the Organization</form:label></td>
					<td><form:input path="orgName" placeholder="Enter Organization Name" /></td>
				</tr>
				<tr>
					<td/>
					<td align="center"><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>