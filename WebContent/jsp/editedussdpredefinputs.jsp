<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Predefined Input Items Manager</title>
</head>
<body>

	<h2>Predefined Input Items Manager</h2>

	<p>You have edited an entry with id ${predeInputId} at <%= new java.util.Date() %></p>
 
<c:url var="mainUrl" value="/ussdpredefinputs" />
<p>Return to <a href="${mainUrl}">Predefined Inputs Home</a></p>

</body>
</html>