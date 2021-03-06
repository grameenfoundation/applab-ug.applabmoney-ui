<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Predefined Inputs Manager</title>
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
	color: #000000;
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

hover.longbtn {
    color: #0066CC;
}

.longbtn{
background-image:
        url('resources/css/ui-lightness/images/ui-bg_gloss-wave_35_9ac482_500x100.png');
    /*background-position: left top;*/
    background-position:absolute;
    background-repeat: repeat-x;
    background-color: transparent;
     -moz-box-align:stretch;
    background-size: 100% 100%;
    border-color: -moz-use-text-color #5C5D61 rgb(92, 93, 97)
        -moz-use-text-color;
    border-style: none none none none;
    border-width: medium 2px 2px medium;
    cursor: pointer;
    display: inline;
    color: #000000;
    font-family: 'Arial', 'Helvetica', sans-serif;
    font-size: 100%;
    font-weight: bold;
    padding: 1px 3px;
    height: 33px;
    width: 140px;
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

td {
	height: 19px;
	width: 30%;
	margin: 0px 2px 0px 2px;
	padding: 0px 5px 0px 5px;
	test-align: center;
	width: 40%;
}

th {
	background: #7CB15C;
	height: 19px;
	border-color: #ffffff;
	text-align: left;
	padding: 4px;
	word-wrap: break-word;
}

td.data {
	border-color: #9AC482;
	border-width: 1px 1px 0 0;
	border-style: solid;
	margin: 1;
	width: 2px;
	padding: 1px;
	background-color: #F3F3EC;
	text-align: left;
	word-wrap: break-word;
}

td.otherdata {
	border-color: #9AC482;
	border-width: 1px 1px 0 0;
	border-style: solid;
	margin: 1;
	width: 1px;
	padding: 1px;
	background-color: #F3F3EC;
	text-align: center;
	word-wrap: break-word;
	padding: 1px;
}

tr.data {
	border: 1px Solid #9AC482;
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
	padding-left: 250px;
}

.alterformfields {
	width: 15px;
	height: 15px;
	text-align: left;
}

.alterlabel {
	vertical-align: top;
}

/*END CONTENT SECTION*/
</style>
</head>
<body>

	<table style="width: 100%;">
		<tr style="background-color: #008000;">
			<td
				style="font-family: sans-serif; font-stretch: wider; color: #F9FFF9;"><h1>AppLab
					Money</h1>
				<div class="header"
					style="font-family: sans-serif; font-stretch: wider; font-size: x-large; color: #000000; text-indent: 6%;">
					Administrator Console</div> <br>
				<div class="header" style="color: #000000;">
					<a style="color: #000000;" href="Me2meUiHome URL" title="Home">Home</a><a>
						> Administration</a>
				</div></td>
		</tr>
	</table>
	<div>
		<div>
			<table style="width: 100%;">
				<tr>
					<td><h2>Manage Predefined Inputs</h2>
						<hr>
					</td>
				</tr>
			</table>
		</div>

		<table style="width: 100%;">
			<tr>
				<td class="content">
					<div>
						<fieldset>
							<legend>
								<h2>Edit Predefined Inputs</h2>
							</legend>
							<%--               action="/applabmoneyaui/editcontacts.html"                 --%>
							<form:form method="post"
								action="/applabmoneyaui/editussdpredefinput/${ussdPredefInput.predefInputId}.html"
								commandName="ussdPredefInput">
								<form:errors path="*" cssClass="errorblock" element="div" />
								<fieldset>
									<table>
										<tr>

											<td class="formlabels"><form:label path="predefInputId">Predefined Input Id</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="predefInputId"
													value="${ussdPredefInput.predefInputId}" disabled="true" />
												<input type="hidden" name="predefInputId"
												value="${ussdPredefInput.predefInputId}" />
											</td>
											<td>
										</tr>
										<tr>
											<td class="formlabels"><form:label
													path="predefInputName">Predefined Input Name</form:label></td>
											<td class="form"><form:input cssClass="formfields"
													path="predefInputName"
													value="${ussdPredefInput.predefInputName}" /></td>
										</tr>
										<tr>
											<td class="formlabels"><form:label
													path="predefInputDescription">Predefined Input Description</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="predefInputDescription"
													value="${ussdPredefInput.predefInputDescription}" /></td>
										</tr>


									</table>
								</fieldset>

								<table>
									<tr>
										<td></td>
										<td><div>
												<br> <input type="button" class ="longbtn"
													value="Create New Predefined Input Item"
													onClick="location.href='/applabmoneyaui/editaddnewussdpredefinputitem/${ussdPredefInput.predefInputId}.html'">
											</div></td>
										<td></td>
										<td></td>
									</tr>
								</table>
								<c:if test="${!empty ussdPredefInput.predefInputItems}">
									<h2>Predefined Items Added</h2>
									<table class="data">
										<tr>
											<th>No.</th>
											<th>Predefined Input Item Name</th>
											<th>Predefined Input Item Code</th>
											<th>Predefined Input Item Order</th>
											<th>Action</th>
										</tr>
										<!--ussdPredefInput.predefInputItems-->
										<c:forEach items="${ussdPredefInput.predefInputItems}"
											var="predefinputitem" varStatus="status">
											<tr class=data>
												<c:if test="${predefinputitem.inputItemId != 0}">
													<td class=otherdata>${status.count}</td>
													<td class=data><input type="hidden"
														name="ussdPredefInput.predefInputItems[${status.index}].inputItemId"
														value="${predefinputitem.inputItemId}" /><a
														href="/applabmoneyaui/editussdpredefinputitem/${predefinputitem.inputItemId}.html">
															${predefinputitem.predefInputItemName}</a><input
														type="hidden"
														name="predefInputItems[${status.index}].predefInputItemName"
														value="${predefinputitem.predefInputItemName}" /></td>
													<td class=data><input type="hidden"
														name="predefInputItems[${status.index}].predefInputItemCode"
														value="${predefinputitem.predefInputItemCode}" />${predefinputitem.predefInputItemCode}</td>
													<td class=data><input type="hidden"
														name="predefInputItems[${status.index}].predefInputItemOrder"
														value="${predefinputitem.predefInputItemOrder}" />${predefinputitem.predefInputItemOrder}</td>
													<td class=data><c:if
															test="${predefinputitem.inputItemId != null}">
															<c:if
																test="${predefinputitem.predefInputItemEnabledFlag != 1}">
																<a
																	href="/applabmoneyaui/activatepredefinputitem/${predefinputitem.inputItemId}.html">Activate
																</a>
															</c:if>
															<c:if
																test="${predefinputitem.predefInputItemEnabledFlag == 1}">
																<a
																	href="/applabmoneyaui/deactivatepredefinputitem/${predefinputitem.inputItemId}.html">Deactivate
																</a>
															</c:if>
															<a
																href="/applabmoneyaui/removepredefinputitem/${predefinputitem.inputItemId}.html">Delete</a>
														</c:if>
													</td>
												</c:if>
											</tr>
										</c:forEach>
									</table>
								</c:if>
								<br />
								<table>
									<tr>
										<td colspan="2" class="savebutton"><br> <input
											 type="submit" value="Update" />&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="button" value="Cancel"
											onClick="location.href='/applabmoneyaui/listussdpredefinputs.html'" />
										</td>
									</tr>
								</table>

							</form:form>
						</fieldset>
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>