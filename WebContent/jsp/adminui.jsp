<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title></title>

<!--[if IE]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
	<div align="justify">
		<table style="width: 100%; border: 1px;">
			<tr style="background-color: #008000; height: 150px">
				<td
					style="font-family: sans-serif; font-stretch: wider; font-size: large; color: #F9FFF9;"><h1>AppLab
						Money</h1>
					<div
						style="font-family: sans-serif; font-stretch: wider; font-size: x-large; color: #000000; text-indent: 6%;">
						<h4>Administrator Console</h4>
					</div>
					<div style="color: #000000;">
						<a style="color: #000000;" href="Me2meUiHome URL" title="Home">Home</a><a>
							Administration</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<hr align="center" size="1" color="#C0C0C0" />
		<br> <br>
	</div>
	<form:form action="adminui.html" commandName="user" method="POST">
    <font color="red"><form:errors/></font>
		<div align="center">
			<table style="width: 32%; border: 1px">
				<tr>
					<td><div style="font-family: sans-serif; font-size: medium;"
							align="right">
							<br>
							<form:label path="userName">User Name</form:label>
						</div></td>
					<td><div align="left">
							<br>
							<form:input path="userName" />
							<font color="red"><form:errors path="userName" /> </font>
						</div></td>
				</tr>
				<tr>
					<td><div style="font-family: sans-serif; font-size: medium;"
							align="right">
							<br> <br>
							<form:label path="password">Password</form:label>
						</div></td>
					<td><div align="left">
							<br>
							<form:input path="password" />
							<font color="red"><form:errors path="password" /> </font>
						</div></td>
				</tr>
				<tr>
					<td>
					<td><div align="right">
							<br> <input
								style="background-color: #0000A0; color: #FFFFFF; font-family: sans-serif; font-size: medium;"
								type="submit" name="Login" value="Login">
						</div></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>