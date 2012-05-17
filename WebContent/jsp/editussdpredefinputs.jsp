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

	<h1>Edit Person</h1>
	<form:form modelAttribute="ussdPredefInput" method="POST"
		action="/editpredefinputs/${ussdPredefInput.predefInputId}.html"
		commandName="ussdPredefInput">

		<table>

			<tr>
				<td><form:label path="predefInputId">Predefined Input ID:</form:label>
				</td>
				<td><form:input path="predefInputId" disabled="true" /></td>
			</tr>

			<tr>
				<td><form:label path="predefInputName">Predefined Input Name</form:label>
				</td>
				<td><form:input path="predefInputName" /></td>
			</tr>
			<tr>
				<td><form:label path="predefInputDescription">Predefined Input Description</form:label>
				</td>
				<td><form:input path="predefInputDescription" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>