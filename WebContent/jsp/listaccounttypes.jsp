<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Account Types Manager</title>
<link type="text/css"
	href="resources/css/ui-lightness/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery-ui-1.8.18.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		// Accordion
		$('#accordion').accordion({
			header : "h3"
		});
		// Tabs
		$('#tabs').tabs();
		$('#button').button();
	});
</script>
<style>
/*GENERAL*/
body {
	font-family: 'Arial', 'Helvetica', sans-serif;
	font-size: 75%;
	line-height: 1.6em;
	background: #F3F3EC;
	padding: 0;
}

h1,h2 {
	font-size: 14px;
	font-weight: bold;
}

h3 {
	font-size: 100%;
	background: #DDB929;
	display: block;
	padding: 1px;
	color: #fff;
}

h4 {
	font-size: 80%;
	background: #DDB929;
	display: block;
	padding: 1px;
	color: #fff;
}

label {
	font-weight: bold;
	text-align: right;
}

/*END GENERAL*/
/* ERROR BLOCK */
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
/*BUTTONS*/
input.createbtn {
	
}

button,.btn {
	background-image:
		url('resources/css/ui-lightness/images/CuteCapLa7.gif');
	background-position: left top;
	background-repeat: repeat-x;
	background-color: transparent;
	border-color: -moz-use-text-color #5C5D61 rgb(92, 93, 97)
		-moz-use-text-color;
	border-style: none none none none;
	border-width: medium 2px 2px medium;
	cursor: pointer;
	display: inline;
	colour: #008000;
	font-family: 'Arial', 'Helvetica', sans-serif;
	font-size: 100%;
	font-weight: bold;
	padding: 1px 3px;
	height: 33px;
	width: 100px;
}

hover.btn {
	color: #0066CC;
}

/*END BUTTONS*/

/*SIDE BAR*/
.navbar {
	vertical-align: top;
	top: 1px;
	width: 20%;
}

/*END SIDE BAR*/

/*CONTENT SECTION*/
.content {
	vertical-align: top;
	top: 1px;
	width: 80%;
}

div.header {
	background: #008000;
	border: 2px Solid #008000;
}

div {
	background: #F3F3EC;
	margin: 2px;
	padding: 1px;
	border: 2px;
}

fieldset {
	border-color: #9AC482;
}

hr {
	border-color: #9AC482;
}

li {
	display: block;
	margin: 2px 2px 2px -20px;
}

tr.header {
	background: #ffffff;
}

th {
	background: #7CB15C;
	height: 19px;
	width: 10%;
	border-color: #ffffff;
	text-align: left;
	padding: 4px;
	word-wrap: break-word;
}

td {
	height: 19px;
	width: 30%;
	margin: 0px 2px 0px 2px;
	padding: 0px 5px 0px 5px;
	test-align: center;
}

td.data {
	border-color: #9AC482;
	border-width: 1px 1px 0 0;
	border-style: solid;
	width: 20%;
	margin: 1;
	padding: 4px;
	background-color: #F3F3EC;
	text-align: left;
}

tr.data {
	border: 1px Solid #9AC482;
}

td.otherdata {
	border-color: #9AC482;
	border-width: 1px 1px 0 0;
	border-style: solid;
	margin: 1;
	width: 5%;
	padding: 1px;
	background-color: #F3F3EC;
	text-align: left;
	word-wrap: break-word;
}

tr.otherdata {
	border: 1px Solid #9AC482;
	width: 5px;
}

table.form {
	padding: 8px;
	width: 100px;
}

td.form {
	padding: 5px;
	width: 400px;
}

table.data {
	width: 100%;
	font-size: 13px;
	border: 1px Solid;
	margin: 0px 0px 1px 1px;
	padding: 0px;
	border-color: #9AC482;
	background-color: #F3F3EC;
	border-collapse: collapse;
	text-align: -webkit-auto;
}

td.savebutton {
	padding-right: 300px;
	text-align: right;
	height: 30px
}

td.formlabels {
	text-align: right;
}

.dropdown {
	width: 157px;
	height: 29px;
}

.formfields {
	width: 150px;
	height: 25px;
}

.labels {
	text-align: right;
}

.otherformfields {
	padding-left: 200px;
}

/*END CONTENT SECTION*/
</style>
</head>
<body>

	<%
		String[][] sysAccountTypeFlagsList = { { "0", "NONE" },
				{ "1", "TEMP" }, { "2", "MCOM" }, { "3", "AGNT" },
				{ "4", "DLER" }, { "5", "MERC" }, { "6", "CORP" } };
		request.setAttribute("sysAccountTypeFlagsList",
				sysAccountTypeFlagsList);
	%>

	<table style="width: 100%;">
		<tr style="background-color: #008000;">
			<td
				style="font-family: sans-serif; font-stretch: wider; color: #F9FFF9;"><h1>AppLab
					Money</h1>
				<div class="header"
					style="font-family: sans-serif; font-stretch: wider; font-size: x-large; color: #000000; text-indent: 6%;">
					Administrator Console</div> <br>
				<div class="header" style="color: #000000;">
					<h2>
						<a style="color: #000000;" href="/metomeui/auilanding.html"
							title="Home">Go Back Home</a>
					</h2>
				</div></td>
		</tr>
	</table>
	<div>
		<div>
			<table style="width: 100%;">
				<tr>
					<td><h2>Manage Account Types</h2>
						<hr>
					</td>
				</tr>
			</table>
		</div>

		<table style="width: 100%;">
			<tr>
				<td class="navbar">
					<div id="accordion">
						<h3>
							<a href="#systemsettings">System Settings</a>
						</h3>
						<ul>
							<li><a href="/metomeui/viewsystemconfiguration.html">System
									Configuration</a>
							</li>
							<li><a href="/metomeui/listmemogroups.html">Memo Groups
									Configuration</a></li>
							<li><a href="/metomeui/listlanguages.html">Languages
									Configuration</a></li>
							<li><a href="/metomeui/listmessages.html">Messages
									Configuration</a></li>
							<li><a href="listmobilendc.html">Mobile NDC
									Configuration</a></li>
						</ul>
						<h3>
							<a href="#ussdmenusetup">Ussd Menu Setup</a>
						</h3>
						<ul>
							<li><a href="/metomeui/listussdmenuitems.html">Ussd Menu
									Items</a>
							</li>
							<li><a href="/metomeui/listussdtransactionkeywords.html">Transaction
									Keywords</a></li>
							<li><a href="/metomeui/listussdpredefinputs.html">Predefined
									Inputs</a></li>
						</ul>
						<h3>
							<a href="#transsettings">Transaction Settings</a>
						</h3>
						<ul>
							<li><a href="/metomeui/viewamlbarringsettings.html">AML
									Settings</a>
							</li>
							<li><a href="/metomeui/listglobalkeywordcharges.html">Charge
									Configuration</a></li>
							<li><a href="/metomeui/listaccounttypes.html">Account
									Type Configuration</a></li>
							<li><a href="/metomeui/listglobalsendlimits.html">Transaction
									Global Send Limits Settings</a></li>
							<li><a href="/metomeui/listglobalreceivelimits.html">Transaction
									Global Receive Limits Settings</a></li>
						</ul>
						<h3>
							<a href="#">Products Setup</a>
						</h3>
						<ul>
							<li><a href="/metomeui/viewmetomesetup.html">Me2Me Setup</a>
							</li>
							<li><a href="/metomeui/viewzimbaconfiguration.html">Zimba
									Setup</a>
							</li>
						</ul>
					</div>
				</td>
				<td class="content">
					<table>
						<tr>
							<td></td>
							<td></td>

							<td><div>
									<input class="btn" type="submit" name="submit"
										value="Create New"
										onClick="location.href='addaccounttype.html'">
								</div></td>
							<td></td>
							<td></td>
						</tr>
					</table> <c:if test="${empty accountTypesList}">
						<div>
							<table>
								<tr>
									<td>There are no Account Types registered on this system <br>
										<br></td>
								</tr>
							</table>
						</div>
					</c:if> <c:if test="${!empty accountTypesList}">
						<h2>Configured Account Types Listing</h2>
						<table class="data">
							<tr>
								<th class="otherdata">Code</th>
								<th class="data">Name</th>
								<th class="otherdata">BitMap</th>
								<th class="otherdata">Mapped to</th>
								<th class="data">Maximum Book Balance</th>
								<th class="data">Action</th>
							</tr>
							<c:forEach items="${accountTypesList}" var="accounttype">
								<tr class=data>
									<td class="otherdata"><a
										href="/metomeui/editaccounttype/${accounttype.accountTypeId}.html">${accounttype.accountTypeCode}</a>
									</td>
									<td class="data">${accounttype.accountTypeName}</td>
									<td class="otherdata">${accounttype.accountTypeBitMap}</td>
									<td class="otherdata"><c:forEach
											items="${sysAccountTypeFlagsList}" var="sysacctypeflg">
											<c:if
												test="${sysacctypeflg[0] == accounttype.sysAccountTypeFlag}">
												<c:out value="${sysacctypeflg[1]}" />
											</c:if>
										</c:forEach></td>
									<td class="data">${accounttype.accountMaximumBookBalance}</td>
									<td class="data"><c:if
											test="${accounttype.enabledFlag == 0}">
											<a
												href="/metomeui/activateaccounttype/${accounttype.accountTypeId}.html">Activate/</a>
										</c:if> <c:if test="${accounttype.enabledFlag == 1}">
											<a
												href="/metomeui/deactivateaccounttype/${accounttype.accountTypeId}.html">Deactivate/</a>
										</c:if> <a href="removeaccounttype/${accounttype.accountTypeId}.html">Delete</a>
								</tr>
							</c:forEach>
						</table>
					</c:if></td>
			</tr>
		</table>
		<!-- 	<table border=1px; width=100%;> -->
		<!-- 		<tr> -->
		<!-- 			<td>Footer</td> -->
		<!-- 		</tr> -->
		<!-- 	</table> -->
	</div>
</body>
</html>