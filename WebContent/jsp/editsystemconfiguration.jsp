systemConfiguration.<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>System Configuration</title>
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
	/* 	border-color: -moz-use-text-color #5C5D61 rgb(92, 93, 97) */
	/* 		-moz-use-text-color; */
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
	width: 20%;
	border-color: #ffffff;
	text-align: left;
	padding: 4px;
}

td {
	height: 19px;
	width: 30%;
	margin: 0px 2px 0px 2px;
	padding: 0px 5px 0px 5px;
	test-align: center;
	width: 40%;
}

td.data {
	border-color: #9AC482;
	border-width: 1px 1px 0 0;
	border-style: solid;
	margin: 1;
	padding: 4px;
	background-color: #F3F3EC;
	text-align: left;
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
	padding-left: 200px;
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
					<h2>
						<a style="color: #000000;" href="/applabmoneyaui/auilanding.html"
							title="Home">Go Back Home</a>
					</h2>
				</div>
			</td>
		</tr>
	</table>
	<div>
		<div>
			<table style="width: 100%;">
				<tr>
					<td><h2>System Configuration</h2>
						<hr></td>
				</tr>
			</table>
		</div>

		<table style="width: 100%;">
			<tr>
				<td class="content">
					<div>
						<fieldset>
							<legend>
								<h2>Configure System</h2>
							</legend>
							<form:form method="post" action="editsystemconfiguration.html"
								commandName="systemConfiguration">
								<form:errors path="*" cssClass="errorblock" element="div" />
								<table>
									<tr>
										<td class="formlabels"><form:label
												path="minPasswordLength">Minimum Password Length(characters)</form:label>
										</td>
										<td class="form"><form:select path="minPasswordLength"
												tabindex="5">
												<form:option value="0" label="--- Select ---" />
												<form:options items="${minPasswordLengthList}" />
											</form:select>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="maxPasswordLength">Maximum Password Length(characters)</form:label>
										</td>
										<td class="form"><form:select path="maxPasswordLength"
												tabindex="5">
												<form:option value="0" label="--- Select ---" />
												<form:options items="${maxPasswordLengthList}" />
											</form:select>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label path="countryCode">Set Country Code: </form:label>
										</td>
										<td class="form"><form:input cssClass="formfields"
												path="countryCode" />
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label path="countryDomain">Set Country Domain: </form:label>
										</td>
										<td class="form"><form:input cssClass="formfields"
												path="countryDomain" />
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label path="currencyCode">Set Currency: </form:label>
										</td>
										<td class="form"><form:select cssClass="formfields"
												path="currencyCode">
												<form:option value="None" label="--- Select ---" />
												<form:option value="UGX">UGX</form:option>
												<form:option value="TSH">TSH</form:option>
												<form:option value="KSH">KSH</form:option>
												<form:option value="GBP">GBP</form:option>
												<form:option value="USD">USD</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="currencyISONumber">Set Currency
                        ISO Number: </form:label></td>
										<td class="form"><form:input cssClass="formfields"
												path="currencyISONumber"></form:input></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label path="msisdnLength">Set MSISDN Length:</form:label>
										<td class="form"><form:select path="msisdnLength">
												<form:option value="0" label="--- Select ---" />
												<form:option value="12">12</form:option>
												<form:option value="13">13</form:option>
												<form:option value="14">14</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:checkbox
												path="msisdnLeadZeroRequired" tabindex="5" value="1"></form:checkbox>
										</td>
										<td class="form"><form:label
												path="msisdnLeadZeroRequired">Set MSISDN lead zero requirement:</form:label>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="allowedOperations">Allowed Operations </form:label></td>
										<td class="form"><form:select path="allowedOperations">
												<form:option value="0" label="--- Select ---" />
												<form:option value="1">This</form:option>
												<form:option value="2">That</form:option>
												<form:option value="3">Other</form:option>
												<form:option value="4">Then</form:option>
												<form:option value="5">What</form:option>
											</form:select></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label path="smsSenderNumber">SMS Sender Number/Name</form:label>
										</td>
										<td class="form"><form:input cssClass="formfields"
												path="smsSenderNumber" value="2"></form:input></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="smsSubscriptionFormat">SMS Message Subscription
                                Display Format</form:label></td>
										<td class="form"><form:select cssClass="formfields"
												path="smsSubscriptionFormat">
												<form:option value="None" label="--- Select ---" />
												<form:option value="blah">blah blah</form:option>
												<form:option value="more blah blah">more blah blah</form:option>
												<form:option value="more blah blah blah">and more blah blah</form:option>
											</form:select></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="subscriptionMaxDisplayCharacters">Subscription Maximum Display Characters </form:label>
										</td>
										<td class="form"><form:select cssClass="formfields"
												path="subscriptionMaxDisplayCharacters">
												<form:option value="None" label="--- Select ---" />
												<form:option value="blah">blah blah</form:option>
												<form:option value="more blah blah">more blah blah</form:option>
												<form:option value="more blah blah blah">and more blah blah</form:option>
											</form:select></td>
									</tr>
									<tr>
										<td class="formlabels"><form:checkbox
												path="chargeCollectSetting"></form:checkbox></td>
										<td class="form"><form:label path="chargeCollectSetting">Charge collect
                                immediate setting </form:label>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:checkbox
												path="notifyOnDelayTrans"></form:checkbox></td>
										<td class="form"><form:label path="notifyOnDelayTrans">Notify on delayed transaction</form:label>
										</td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="notifyOnDelaySeconds">Notify  on delay seconds</form:label>
										</td>
										<td class="form"><form:select path="notifyOnDelaySeconds"
												cssClass="formfields">
												<form:option value="0" label="--- Select ---" />
												<form:option value="5">5</form:option>
												<form:option value="10">10</form:option>
												<form:option value="20">20</form:option>
											</form:select></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="notifyOnDelayMessageID">Notify on delay message ID </form:label>
										</td>
										<td class="form"><form:input cssClass="formfields"
												path="notifyOnDelayMessageID"></form:input></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="maintenanceModeFlag">Maintenance Mode</form:label>
									<tr>
										<td></td>
										<td class="form"><form:label path="maintenanceModeFlag">On</form:label>
											<form:radiobutton path="maintenanceMode" class="formRadio"
												value="1"></form:radiobutton></td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td class="form"><form:label path="maintenanceModeFlag">Off(Default)</form:label>
											<form:radiobutton path="maintenanceMode" class="formRadio"
												value="0"></form:radiobutton></td>
									</tr>
									<tr>
										<td class="formlabels"><form:label
												path="maintenanceModeMessageID"> Maintenance Mode
                                Message ID</form:label></td>
										<td class="form"><form:input cssClass="formfields"
												path="maintenanceModeMessageID"></form:input>
										</td>
									</tr>
									<tr>
										<td colspan="2" class="savebutton"><br> <input
											type="submit" value="Save Changes" /> <input type="button"
											value="Cancel"
											onClick="location.href='/applabmoneyaui/viewsystemconfiguration.html'" />
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