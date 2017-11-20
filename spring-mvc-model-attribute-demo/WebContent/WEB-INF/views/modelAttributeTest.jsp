<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@ModelAttribute test</title>
<style type="text/css">
h1, h2{
	color: #08298A;
	text-align: center;
}
</style>
</head>
<body>
	<h1>@ModelAttributes test results</h1>
	<hr/>
	<div align="center">
		<c:if test="${testdata5A != null && testdata5B != null}">
			<h3 style="color: #DF0101">City: ${testdata5A}</h3>
			<h3 style="color: #DF0101">Zip code: ${testdata5B}</h3>
		</c:if>
	</div>
</body>
</html>