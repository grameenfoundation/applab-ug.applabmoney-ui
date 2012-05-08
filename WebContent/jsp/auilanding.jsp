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
	left: 36%;
	margin-top: 45x;
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
	margin-left: 40%;
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
	top:15px;
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
					<li><a href="#tabs-2">Password Settings</a></li>
					<li><a href="#tabs-3">Mobile/MSISDN Settings</a></li>
					<li><a href="#tabs-4">Transaction Settings</a></li>
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
		<div id="tabs">
			<ul>
				<li class="tabs"><a href="#tabs-1">Current System Settings</a>
				</li>
				<li class="tabs"><a href="#tabs-2">Password Settings</a></li>
				<li class="tabs"><a href="#tabs-3">Mobile/MSISDN Settings</a></li>
				<li class="tabs"><a href="#tabs-4">Transaction Settings</a></li>
			</ul>

			<div id="tabs-1">An overview of the system Settings e.g. time
				zone, Language</div>

			<div id="tabs-2">
				<form:form action="auilanding.html" commandName="passwordSettings"
					method="POST">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<fieldset>
						<form:label path="name">Name: </form:label>
						<form:input path="name" tabindex="1"></form:input>
						<br>
						<form:label path="precedence">Precedence:</form:label>
						<form:select path="precedence" tabindex="2">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${precedenceList}" />
						</form:select>
						<br>

						<form:label path="enforcePasswordComplexityRequirements">Password must meet complexity requirements</form:label>
						<form:checkbox path="enforcePasswordComplexityRequirements"
							class="formCheckbox" tabindex="3"></form:checkbox>
						<br>

						<form:label path="enforceMinPasswordLength">Enforce Minimum Password Length</form:label>
						<form:checkbox path="enforceMinPasswordLength"
							class="formCheckbox" tabindex="4"></form:checkbox>
						<br>
						<form:label path="minPasswordLength">Minimum Password Length(characters)</form:label>
						<form:select path="minPasswordLength" tabindex="5">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${minPasswordLengthList}" />
						</form:select>
						<br>

						<form:label path="enforceMaxPasswordLength">Enforce Maximum Password Length</form:label>
						<form:checkbox path="enforceMaxPasswordLength"
							class="formCheckbox" tabindex="6"></form:checkbox>
						<br>

						<form:label path="maxPasswordLength">Maximum Password Length(characters)</form:label>
						<form:select path="maxPasswordLength" tabindex="7">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${maxPasswordLengthList}" />
						</form:select>
						<br>

						<form:label path="enforceMinPasswordAge">Enforce Minimum Password Age</form:label>
						<form:checkbox path="enforceMinPasswordAge" class="formCheckbox"
							tabindex="8"></form:checkbox>
						<br>

						<form:label path="minPasswordAge">User cannot change password within (days)</form:label>
						<form:select path="minPasswordAge" tabindex="9">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${minPasswordAgeList}" />
						</form:select>
						<br>

						<form:label path="enforceMaxPasswordAge">Enforce Maximum Password Age</form:label>
						<form:checkbox path="enforceMaxPasswordAge" class="formCheckbox"
							tabindex="10"></form:checkbox>
						<br>

						<form:label path="maxPasswordAge">User must change password within (days)</form:label>
						<form:select path="maxPasswordAge" tabindex="11">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${maxPasswordAgeList}" />
						</form:select>
						<br>

						<form:label path="enforceLockoutPolicy">Enforce lockout
                            policy</form:label>

						<form:checkbox path="enforceLockoutPolicy" class="formCheckbox"
							tabindex="12"></form:checkbox>
						<br>
						<form:label path="maxFailedLoginCount">Number of failed logon attempts: </form:label>
						<form:select path="maxFailedLoginCount" tabindex="11">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${loginAttemptCountList}" />
						</form:select>
						<br>
						<form:label path="failedLoginResetCount">Reset failed logon attempts count after(mins) </form:label>
						<form:select path="failedLoginResetCount" tabindex="11">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${resetFailedLogonTimerList}" />
						</form:select>
						<br>

						<form:label path="accountUnlock">Account will unlocked:</form:label><br>
						<form:label path="accountUnlock" class="radioLabel">For a Duration of(mins)</form:label>
						<form:radiobutton class="formRadio" path="accountUnlock"
							value="true"></form:radiobutton>
						<form:select class="otherselect" path="accountLockDuration" tabindex="15">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${accountLockDurationList}" />
						</form:select>
						<br>
						<form:label path="accountUnlock" class="radioLabel">Until Administrator manually unlocks account</form:label>
						<form:radiobutton class="formRadio" path="accountUnlock"
							value="false"></form:radiobutton>
						<br>

					</fieldset>
					<input class="formInputButton" type="submit" name="submit"
						value="Save">
					<input class="formInputButton" type="button" name="cancel"
						value="Cancel">
				</form:form>
			</div>
			<div id="tabs-3">
				<form method="post" action="#Mobile/MSISDN SettingsSave">
					<fieldset>

						<label for="setCountryCode">Set Country Code: </label> <input
							type="text" name="setCountryCode" id="setCountryCode" value=""
							size="12" maxlength="30" tabindex="1"><br> <label
							for="setCountryDomain">Set Country Domain: </label> <input
							type="text" name="setCountryDomain" id="setCountryDomain"
							value="" size="12" maxlength="30" tabindex="2"><br>
						<label for="setCurrencyCode">Set Currency Code </label> <select
							name="setCurrencyCode" tabindex="3">
							<option>UGX</option>
							<option>TSH</option>
							<option>KSH</option>
							<option>GBP</option>
							<option>USD</option>
						</select><br> <label for="setCurrencyISONumber">Set Currency
							ISO Number: </label> <input type="text" name="setCurrencyISONumber"
							id="setCurrencyISONumber" value="" size="12" maxlength="30"
							tabindex="4"><br> <label for="setMsisdnLength">Set
							MSISDN Lenghth</label> <select name="setMsisdnLength">
							<option>12</option>
							<option>13</option>
							<option>14</option>
						</select><br> <label for="setMSISDNLeadZero">Set MSISDN lead
							zero requirement</label> <input class="formCheckbox" type="checkbox"
							name="setMSISDNLeadZero" value="" tabindex="5"><br>

					</fieldset>
					<input class="formInputButton" type="submit" name="submit"
						value="Save"> <input class="formInputButton" type="button"
						name="cancel" value="Cancel">
				</form>
			</div>
			<div id="tabs-4">
				<form method="post" action="#TransactionSettingsSave">
					<fieldset>
						<fieldset class="subfieldset">
							<legend>Restrictions</legend>

							<label for="failedTransferLock">Failed Transfer Lock</label> <input
								class="formText" type="text" name="failedTransferLock"
								id="failedTransferLock" value="" size="12" maxlength="30"
								tabindex="1"><br> <label for="autoCreateTempSub">
								Auto-create Temp Sub</label><input class="formCheckbox" type="checkbox"
								name="autoCreateTempSub" value="" tabindex="2"><br>
							<label for="tempRestrictionSettings">Temp Restriction
								settings: </label><br> <label class="radioLabel">Setting1</label><input
								class="formRadio" type="radio" name="setting1" value="setting1"><br>
							<label class="radioLabel">Setting2</label><input
								class="formRadio" type="radio" name="setting1" value="setting2"><br>
							<label class="radioLabel">Setting3</label><input
								class="formRadio" type="radio" name="setting1" value="setting3"><br>
							<label class="radioLabel">Setting4</label><input
								class="formRadio" type="radio" name="setting1" value="setting4"><br>

							<label for="allowedOperations">Allowed operations </label> <select
								name="allowedoperations" multiple size="5">
								<option value="1">This</option>
								<option value="2">That</option>
								<option value="3">Other</option>
								<option value="4">Then</option>
								<option selected value="5">What</option>
							</select><br>
						</fieldset>
						<fieldset class="subfieldset">
							<legend>Subscription Settings</legend>
							<label for="smsSender">SMS Sender Number/Name</label> <input
								class="formText" type="text" name="smsSender" value=""><br>
							<label for="smsSubFormat">SMS Message Subscription
								Display Format</label> <select name="smsSubFormat">
								<option>blah blah</option>
								<option>more blah blah</option>
								<option>and more blah blah</option>
							</select> <br> <br> <label for="subMaxDisplayCharacters">Subscription
								Maximum Display Characters </label> <select
								name="subMaxDisplayCharacters">
								<option>blah blah</option>
								<option>more blah blah</option>
								<option>and more blah blah</option>
							</select> <br> <br>
						</fieldset>
						<fieldset class="subfieldset">
							<legend>Notification Settings</legend>
							<label for="chargeCollectSetting">Charge collect
								immediate setting </label> <input class="formText" type="text"
								name="chargeCollectSetting" value=""><br> <label
								for="notifyOnDelayTrans">Notify on delayed transaction</label> <input
								class="formCheckbox" type="checkbox" name="notifyOnDelayTrans"
								value=""><br> <label for="notifyOnDelaySeconds">Notify
								on delay seconds</label> <select name="notifyondelayseconds">
								<option>5</option>
								<option>10</option>
								<option>20</option>
							</select><br> <label for="notifyOnDelayMsgID">Notify on delay
								message ID </label> <input type="text" name="notifyondelaymsgID"
								value=""><br>
						</fieldset>
						<fieldset class="subfieldset">
							<legend>Maintenance Mode Settings</legend>
							<label for="maintenanceMode"> Maintenance mode </label> <label
								class="radioLabel">On</label><input class="formRadio"
								type="radio" name="maintenanceModeOn" value="On"> <label
								class="radioLabel"> Off(default)</label><input class="formRadio"
								type="radio" name="maintenanceModeOff" value="Off"><br>
							<label for="maintenanceModeMsgID"> Maintenance Mode
								Message ID</label> <input type="text" name="smssender" value=""><br>
						</fieldset>
						<input class="formInputButton" type="submit" name="submit"
							value="Save"> <input class="formInputButton"
							type="button" name="cancel" value="Cancel">

					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>