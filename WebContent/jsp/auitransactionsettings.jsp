<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="created" content="Tue, 10 Apr 2012 09:14:23 GMT">
<meta name="description" content="">
<meta name="keywords" content="">
<title></title>
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

<style type="text/css">
body {
	font: 90% "Trebuchet MS", sans-serif;
	margin: 5px;
}

#navbar {
	float: left;
	top: 1px;
	width: 20%;
}

#content {
	float: left;
	top: 1px;
	width: 79.5%;
	margin-left: 5px;
}

logo {
	width: 222px;
	height: 59px;
	font-size: 1.2em;
	position: relative;
	overflow: hidden;
	overflow-x: hidden;
	overflow-y: hidden;
	display: inline;
	text-indent: -5000px;
	float: left;
	margin: 0 0 0 20px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	margin-left: 20px;
}

fieldset {
	font: "Helvetica Neue", helvetica, arial, sans-serif;
	color: #666;
	background-color: #efefef;
	padding: 3px;
	border: solid 1px #d3d3d3;
	alignment-adjust: central;
	width: 100%;
}

fieldset.subfieldset {
	font: "Helvetica Neue", helvetica, arial, sans-serif;
	color: #666;
	padding: 2px;
	margin: 2.5%;
	background-color: #efefef;
	border: solid 1px #d3d3d3;
	position: relative;
	alignment-adjust: middle;
	width: 95%;
}

legend {
	color: #666;
	font-weight: bold;
	background-color: #d3d3d3;
	padding: 2px 6px;
	margin-bottom: 8px;
}

label {
	margin-left: 50px;
	margin-right: 10px;
	margin-top: 4px;
	margin-bottom: 4px;
	position: absolute;
	text-align: right;
	padding-top: 2px;
	padding-right: 10px;
	padding-bottom: 2px;
	padding-left: 10px;
	text-indent: -15px;
	font-size: 14px;
	font-weight: 500;
	color: #333;
	width: 30%;
	display: block;
}

input,textarea {
	position: relative;
	left: 40%;
	margin-top: 4px;
	margin-bottom: 4px;
	height: 25px;
	width: 150px;
	*overflow: hidden;
}

input.formRadio {
	display: inline;
	position: absolute;
	left: 40%;
	margin-top: 5px;
	margin-bottom: 4px;
	height: 15px;
	width: 15px;
}

input.formCheckbox {
	position: relative;
	left: 40%;
	top: -5px;
	width: auto;
	display: inline-block;
}

li.tabs {
	padding: 5px;
	width: 24.4%;
}

select {
	position: relative;
	left: 40%;
	margin-top: 4px;
	margin-bottom: 4px;
	height: 27px;
	width: 155px
}

select.otherselect {
	display: inline;
	position: absolute;
	left: 60%;
	margin-top: 5px;
	margin-bottom: 5px;
	height: 27px;
	width: 155px
}

label.fieldLabel {
	display: inline;
	float: none;
}

label.radioLabel {
	display: inline;
	position: absolute;
	margin-left: 45%;
	text-align: left;
	margin-top: 5px;
	margin-bottom: 10px;
	margin-right: 10px;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

input.formInputButton {
	position: relative;
	right: 60px;
	font-size: 1.2em;
	font-weight: bolder;
	text-align: center;
	color: #ffffff;
	background: #004040 repeat-x;
	padding: 1px;
	border: solid 1px #C0C0C0;
	margin-left: 15px;
	cursor: pointer;
	width: 80px;
	top: 15px;
}

input.formInputButton:hover {
	background-image: url(bg_button_hover.png);
}

input.formInputButton:active {
	background-image: url(bg_button.png);
}

table,td,tr {
	border: 1px, solid, black;
}
</style>
</head>
<body>
	<div align="justify">
		<table style="width: 100%;">
			<tr style="background-color: #008000;">
				<td
					style="font-family: sans-serif; font-stretch: wider; color: #F9FFF9;"><h1>AppLab
						Money</h1>
					<div
						style="font-family: sans-serif; font-stretch: wider; font-size: x-large; color: #000000; text-indent: 6%;">
						Administrator Console</div> <br>
					<div style="color: #000000;">
						<a style="color: #000000;" href="Me2meUiHome URL" title="Home">Home</a><a>
							> Administration</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<hr style="alignment-adjust: central; size: 1; color: #C0C0C0" />
		<br> <br>
	</div>
	<div id="navbar" style="">
		<div id="accordion">
			<div>
				<h3>
					<a href="#">System Configuration</a>
				</h3>
				<ul>
					<li><a href="#tabs-1">View current Settings</a></li>
					<li><a href="auilanding.html">Password Settings</a></li>
					<li><a href="auimsisdnsettings.html">Mobile/MSISDN
							Settings</a></li>
					<li><a href="auitransactionsettings.html">Transaction
							Settings</a></li>
				</ul>
			</div>
			<div>
				<h3>
					<a href="#">Message Settings</a>
				</h3>
			</div>
			<div>
				<h3>
					<a href="#">Language Settings</a>
				</h3>
			</div>
			<div>
				<h3>
					<a href="#">Accounts Configuration</a>
				</h3>
			</div>
			<div>
				<h3>
					<a href="#">Memo Groups Configuration</a>
				</h3>
			</div>
			<div>
				<h3>
					<a href="#">Mobile NDC Configuration</a>
				</h3>
			</div>
		</div>
	</div>
	<div id="content" style="">
		<div>
			<form:form action="auitransactionsettings.html"
				commandName="transactionSettings" method="post">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<fieldset>
					<fieldset class="subfieldset">
						<legend>Restrictions</legend>

						<form:label path="failedTransferLock">Failed Transfer Lock</form:label><br>
						<form:label path="failedTransferLock" class="radioLabel">Yes</form:label>
						<form:radiobutton path="failedTransferLock" class="formRadio" value ="true" tabindex="1"></form:radiobutton><br>
						<form:label path="failedTransferLock" class="radioLabel">No</form:label>
						<form:radiobutton path="failedTransferLock" class="formRadio" value ="false" tabindex="2"></form:radiobutton> 
						<br>
						<form:label path="autoCreateTempSub">Auto-create Temp Sub</form:label>
						<form:checkbox class="formCheckbox" path="autoCreateTempSub"
							tabindex="3"></form:checkbox>
						<br>
						<form:label path="tempRestrictionSettings">Temp Restriction
                                settings: </form:label>
						<br>
						<form:label path="tempRestrictionSettings" class="radioLabel">Setting1</form:label>
						<form:radiobutton path="tempRestrictionSettings" class="formRadio"
							value="setting1"></form:radiobutton>
						<br>
						<form:label path="tempRestrictionSettings" class="radioLabel">Setting2</form:label>
						<form:radiobutton path="tempRestrictionSettings" class="formRadio"
							value="setting2"></form:radiobutton>
						<br>
						<form:label path="tempRestrictionSettings" class="radioLabel">Setting3</form:label>
						<form:radiobutton path="tempRestrictionSettings" class="formRadio"
							value="setting3"></form:radiobutton>
						<br>
						<form:label path="tempRestrictionSettings" class="radioLabel">Setting4</form:label>
						<form:radiobutton path="tempRestrictionSettings" class="formRadio"
							value="setting4"></form:radiobutton>
						<br>

						<form:label path="allowedOperations">Allowed Operations </form:label>
						<form:select path="allowedOperations">
							<form:option value="0" label="--- Select ---" />
							<form:option value="1">This</form:option>
							<form:option value="2">That</form:option>
							<form:option value="3">Other</form:option>
							<form:option value="4">Then</form:option>
							<form:option value="5">What</form:option>
						</form:select>
						<br>
					</fieldset>
					<fieldset class="subfieldset">
						<legend>Subscription Settings</legend>
						<form:label path="smsSenderID">SMS Sender Number/Name</form:label>
						<form:input class="formText" path="smsSenderID"></form:input>
						<br>
						<form:label path="smsSubscriptionFormat">SMS Message Subscription
                                Display Format</form:label>
						<form:select path="smsSubscriptionFormat">
							<form:option value="None" label="--- Select ---" />
							<form:option value="blah">blah blah</form:option>
							<form:option value="more blah blah">more blah blah</form:option>
							<form:option value="more blah blah blah">and more blah blah</form:option>
						</form:select>
						<br> <br>
						<form:label path="subscriptionMaxDisplayCharacters">Subscription Maximum Display Characters </form:label>
						<form:select path="subscriptionMaxDisplayCharacters">
							<form:option value="None" label="--- Select ---" />
							<form:option value="blah">blah blah</form:option>
							<form:option value="more blah blah">more blah blah</form:option>
							<form:option value="more blah blah blah">and more blah blah</form:option>
						</form:select>
						<br> <br>
					</fieldset>
					<fieldset class="subfieldset">
						<legend>Notification Settings</legend>
						<form:label path="chargeCollectSetting">Charge collect
                                immediate setting </form:label>
						<form:checkbox path="chargeCollectSetting" class="formCheckbox" ></form:checkbox>
						<br>
						<form:label path="notifyOnDelayTrans">Notify on delayed transaction</form:label>
						<form:checkbox class="formCheckbox" path="notifyOnDelayTrans"></form:checkbox>
						<br>
						<form:label path="notifyOnDelaySeconds">Notify  on delay seconds</form:label>
						<form:select path="notifyOnDelaySeconds">
							<form:option value="0" label="--- Select ---" />
							<form:option value="5">5</form:option>
							<form:option value="10">10</form:option>
							<form:option value="20">20</form:option>
						</form:select>
						<br>
						<form:label path="notifyOnDelayMessageID">Notify on delay message ID </form:label>
						<form:input path="notifyOnDelayMessageID"></form:input>
						<br>
					</fieldset>
					<fieldset class="subfieldset">
						<legend>Maintenance Mode Settings</legend>
						<form:label path="maintenanceMode">Maintenance Mode</form:label>
                        <form:label path="maintenanceMode" class="radioLabel">On</form:label>
                        <form:radiobutton path="maintenanceMode" class="formRadio" value ="true"></form:radiobutton><br>
                        <form:label path="maintenanceMode" class="radioLabel">Off(Default)</form:label>
                        <form:radiobutton path="maintenanceMode" class="formRadio" value ="false"></form:radiobutton> 
                        <br>
						<form:label path="maintenanceModeMessageID"> Maintenance Mode
                                Message ID</form:label>
						<form:input path="maintenanceModeMessageID"></form:input>
							<br>
					</fieldset>
					<input class="formInputButton" type="submit" name="submit"
						value="Save"> <input class="formInputButton" type="button"
						name="cancel" value="Cancel">

				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>