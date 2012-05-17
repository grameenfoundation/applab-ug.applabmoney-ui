<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Users Manager</title>
</head>
<body>

	<h2>Users Manager</h2>

	<c:if test="${empty userList}">
		<tr>
			<td>There are no users configured on this system</td>
		</tr><br><br>
	</c:if>

	<form:form method="post" action="adduser.html" commandName="user">

		<table>
			<tr>
				<td><form:label path="userName">UserName</form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
			</tr>
			<!-- 			<tr> -->
			<%-- 				<td><form:label path="confirmPassword">Confirm Password</form:label> --%>
			<!-- 				</td> -->
			<%-- 				<td><form:input path="confirmPassword" /> --%>
			<!-- 				</td> -->
			<!-- 			</tr> -->
			<tr>
				<td><form:label path="firstName">FirstName</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">LastName</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="middleName">MiddleName</form:label></td>
				<td><form:input path="middleName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email Address</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">Phone Contact</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>

			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:select path="role">
						<form:option value="Guest" label="Guest" />
						<form:option value="Admin" label="Admin" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="adduser" />
				</td>
			</tr>
		</table>
	</form:form>


	<c:if test="${!empty userList}">
		<h3>System Users</h3>
		<table class="data">
			<tr>
				<th>UserName</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>MiddleName</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userName}</td>
					<td>${user.lastName}</td>
					<td>${user.firstName}</td>
					<td>${user.middleName}</td>
					<td>${user.email}</td>
					<td>${user.role}</td>
					<td>${user.telephone}</td>
					<td><a href="#activate/${user.userId}">Activate/</a><a
						href="removeUser/${user.userId}.html">Delete</a><a
						href="#edit/${user.userId}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>