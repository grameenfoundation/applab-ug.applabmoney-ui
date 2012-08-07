<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Transaction Keywords Manager</title>
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

/*BUTTONSbutton,*/
.btn {
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
	align: right;
}

hover.btn {
	color: #0066CC;
}

.longbtn {
	background-image:
		url('resources/css/ui-lightness/images/CuteCapLa7.gif');
	/*background-position: left top;*/
	background-position: absolute;
	background-repeat: repeat-x;
	background-color: transparent;
	-moz-box-align: stretch;
	background-size: 100% 100%;
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
	width: 140px;
}

hover.longbtn {
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

td {
	height: 19px;
	width: 40%;
	margin: 0px 2px 0px 2px;
	padding: 0px 5px 0px 5px;
	test-align: center;
}

th {
	background: #7CB15C;
	height: 19px;
	width: 20%;
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
	width: 20%;
	padding: 1px;
	background-color: #F3F3EC;
	text-align: left;
	word-wrap: break-word;
}

th.otherdata {
	background: #7CB15C;
	height: 19px;
	width: 5%;
	border-color: #ffffff;
	text-align: left;
	padding: 4px;
	word-wrap: break-word;
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
	padding-left: 250px;
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
					<td><h2>Manage Transaction Keywords</h2>
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
								<h2>Edit Transaction Keyword</h2>
							</legend>
							<form:form method="post"
								action="/metomeui/editussdtransactionkeyword/${ussdTransactionKeyword.keywordId}.html"
								commandName="ussdTransactionKeyword">
								<form:errors path="*" cssClass="errorblock" element="div" />
								<fieldset>
									<table>
										<tr>
											<td class="formlabels"><form:label path="keywordId">Transaction Keyword Id:</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="keywordId"
													value="${ussdTransactionKeyword.keywordId}" disabled="true" /><input
												type="hidden" name="keywordId"
												value="${ussdTransactionKeyword.keywordId}" /></td>
										</tr>
										<tr>
											<td class="formlabels"><form:label path="keywordCode">Transaction Keyword Code:</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="keywordCode" maxlength="10"
													value="${ussdTransactionKeyword.keywordCode}" /></td>
										</tr>
										<tr>
											<td class="formlabels"><form:label path="keywordName">Transaction Keyword Name</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="keywordName"
													value="${ussdTransactionKeyword.keywordName}" />
											</td>
										</tr>
										<tr>
											<td class="formlabels"><form:label
													path="keywordDescription">Transaction Keyword Description</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="keywordDescription"
													value="${ussdTransactionKeyword.keywordDescription}" />
											</td>
										</tr>
										<tr>
											<td class="formlabels"><form:label
													path="keywordStepsCount">Transaction Keyword Step Count</form:label>
											</td>
											<td class="form"><form:input cssClass="formfields"
													path="keywordStepsCount"
													value="${ussdTransactionKeyword.keywordStepsCount}" />
											</td>
										</tr>
									</table>
								</fieldset>
								<table>
									<tr>
										<td></td>
										<td><div>
												<br> <input type="button"
													value="Create New Keyword Step"
													onClick="location.href='/metomeui/editaddnewussdkeywordstep/${ussdTransactionKeyword.keywordId}.html'">
											</div>
										</td>
										<td></td>
										<td></td>
									</tr>
								</table>
								<c:if test="${!empty ussdTransactionKeyword.keywordSteps}">
									<h2>Keyword Steps Added</h2>
									<table class="data">
										<tr>
											<th class="otherdata">No.</th>
											<th>Step Menu Name</th>
											<th class="otherdata">Step Menu Number</th>
											<th class="otherdata">Is First Step Flag</th>
											<th class="otherdata">Is Last Step Flag</th>
											<th class="otherdata">Has Predefined Input</th>
											<th>Predefined Input</th>
											<th class="otherdata">Use Fixed Value</th>
											<th>Fixed Value</th>
											<th class="otherdata">Action</th>
										</tr>
										<c:forEach items="${ussdTransactionKeyword.keywordSteps}"
											var="keywordstep" varStatus="status">
											<tr class="data">
												<c:if test="${keywordstep.keywordStepId != 0}">
													<td class="otherdata">${status.count} <input size="2"
														type="hidden"
														name="keywordSteps[${status.index}].keywordStepId"
														value="${keywordstep.keywordStepId}" /></td>
													<td class="data"><input type="hidden"
														name="keywordSteps[${status.index}].stepMenuName"
														value="${keywordstep.stepMenuName}" /> <a
														href="/metomeui/editussdkeywordstep/${keywordstep.keywordStepId}.html">${keywordstep.stepMenuName}</a>
													</td>
													<td class="otherdata"><input type="hidden"
														name="keywordSteps[${status.index}].stepMenuNumber"
														value="${keywordstep.stepMenuNumber}" />
														${keywordstep.stepMenuNumber}</td>
													<td class="otherdata"><c:if
															test="${keywordstep.isFirstStepFlag == 0}"> No
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].isFirstStepFlag"
																value="0" />
														</c:if> <c:if test="${keywordstep.isFirstStepFlag == 1}"> Yes
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].isFirstStepFlag"
																value="1" />
														</c:if>
													</td>
													<td class="otherdata"><c:if
															test="${keywordstep.isLastStepFlag == 0}"> No
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].isLastStepFlag"
																value="0" />
														</c:if> <c:if test="${keywordstep.isLastStepFlag == 1}"> Yes
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].isLastStepFlag"
																value="1" />
														</c:if>
													</td>
													<td class="otherdata"><c:if
															test="${keywordstep.hasPredefInputFlag == 0}"> No
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].hasPredefInputFlag"
																value="0" />
														</c:if> <c:if test="${keywordstep.hasPredefInputFlag == 1}"> Yes
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].hasPredefInputFlag"
																value="1" />
														</c:if>
													</td>
													<td class="data"><c:forEach items="${predefInputList}"
															var="predefinput">
															<c:if
																test="${predefinput.predefInputId == keywordstep.predefInput.predefInputId}">
																<c:out value="${predefinput.predefInputName}" />
															</c:if>
														</c:forEach><input type="hidden"
														name="keywordSteps[${status.index}].predefInputId"
														value="${keywordstep.predefInput.predefInputId}" />
													</td>
													<td class="otherdata"><c:if
															test="${keywordstep.useFixedValueFlag == 0}"> No
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].useFixedValueFlag"
																value="0" />
														</c:if> <c:if test="${keywordstep.useFixedValueFlag == 1}"> Yes
														<input size="3" type="hidden"
																name="keywordSteps[${status.index}].useFixedValueFlag"
																value="1" />
														</c:if></td>
													<td class="data"><input type="hidden"
														name="keywordSteps[${status.index}].fixedValue"
														value="${keywordstep.fixedValue}" />
														${keywordstep.fixedValue}</td>
													<td class=data><c:if
															test="${keywordstep.keywordStepId != null}">
															<a
																href="/metomeui/removekeywordstep/${keywordstep.keywordStepId}.html">Delete</a>
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
										<td></td>
										<td></td>
										<td><input type="submit" value="Update" />
											&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Cancel"
											onClick="location.href='/metomeui/listussdtransactionkeywords.html'" />
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