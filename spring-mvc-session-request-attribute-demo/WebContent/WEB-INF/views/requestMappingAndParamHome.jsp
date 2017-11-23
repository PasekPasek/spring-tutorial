<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@RequestMapping and @requestParam test bed</title>
<style type="text/css">
input[type=text] {
	padding: 10px;
	margin: 10px;
	font-size: 20px;
}
input[type=submit]{
	border: none;
	background-color: #4CAF50;
	color: white;
	margin: 16px;
	cursor: pointer;
	font-size: 20px;
}

h2{
	color: #08298A;
	text-align: center;
}
</style>
</head>
<body>
	<div align="left">
		<h2 align="center">Hello, welcome to the @Requestmapping & @RequestParam test Bed</h2>
		<hr>
		<form action="test1">
			<h3>test 1: testing @RequestParam without explicit attributes</h3>
			<label id="organiztion-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="Submit">
		</form>
		<br/><br/>
		<form action="test2">
			<h3>test 2: testing @RequestParam 'method' attribute</h3>
			<label id="organiztion-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="Submit">
		</form>
		<br/><br/>
		<form action="test3">
			<h3>test 3: testing @RequestParam fallback feature</h3>
			<input type="submit" value="Submit">
		</form>
		<br/><br/>
		<form action="test4">
			<h3>test 4: testing @RequestParam 'defaultValue' attribute</h3>
			<label id="organiztion-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="Submit">
		</form>
		<br/><br/>
		<form action="test5">
			<h3>test 5: testing @RequestParam without name or value attribute</h3>
			<label id="organiztion-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>