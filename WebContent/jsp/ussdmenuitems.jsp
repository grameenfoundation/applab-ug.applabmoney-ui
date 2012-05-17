<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Menu Items Manager</title>
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
    height:33px;
    width: 100px;
    
}

hover.btn{
color:#0066CC;
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
    width: 20%;
}

td.data {
    border-color: #9AC482;
    border-width: 1px 1px 0 0;
    border-style: solid;
    margin: 1;
    padding: 4px;
    background-color: #F3F3EC;
    text-align:left;
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
    height:30px
}

td.formlabels{
text-align:right;
}

.dropdown{
width: 157px;
height: 29px;
}

.formfields{
width: 150px;
height: 25px;
}

.labels{
text-align:right;
}

.otherformfields {
    padding-left:200px;
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
					<td><h2>Menu Items Manager</h2>
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
							<a href="ussdmenuitems.html">Ussd Menu Items Setup</a>
						</h3>
						<ul>
							<li><a href="ussdmenuitems.html">Ussd Menu Items Listing</a>
							</li>
							<li><a href="addussdmenuitems.html">Create Ussd Menu
									Items</a></li>
						</ul>
						<h3>
							<a href="ussdtransactionkeywords.html">Transaction Keywords
								Setup</a>
						</h3>
						<ul>
							<li><a href="ussdtransactionkeywords.html">Transaction
									Keywords</a></li>
							<li><a href="ussdkeywordsteps.html">Keyword Steps</a></li>
						</ul>
						<h3>
							<a href="ussdpredefinputs.html">Predefined Inputs Setup</a>
						</h3>
						<ul>
							<li><a href="ussdpredefinputs.html">Predefined Inputs</a></li>
							<li><a href="ussdpredefinputitems.html">Predefined Input
									Items</a></li>
						</ul>
						<h3>
                            <a href="ussdrequests.html">USSD Requests</a>
                        </h3>
                        <ul>
                            <li><a href="ussdrequests.html">USSD Requests</a>
                            </li>
                        </ul>
					</div>
				</td>
				<td class="content">
					<table>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><div>
									<input class="btn" type="submit" name="submit" value="Create New"
										onClick="location.href='addussdmenuitems.html'">
								</div></td>
						</tr>
					</table> <c:if test="${empty ussdMenuItemsList}">
						<div>
							<table>
								<tr>
									<td>There are no menu items configured on this system <br>
										<br></td>
								</tr>
							</table>
						</div>
					</c:if> <c:if test="${!empty ussdMenuItemsList}">
						<h2>System Ussd Menu Items Listing</h2>
						<table class="data">
							<tr>
								<th>Menu Item Name</th>
								<th>Menu Item Order</th>
								<th>Keyword ID</th>
								<th>Parent Menu ID</th>
<!-- 								<th>Action</th> -->
							</tr>
							<c:forEach items="${ussdMenuItemsList}" var="menuitem">
								<tr class=data>
									<td class=data>${menuitem.menuItemName}</td>
									<td class=data>${menuitem.menuItemOrder}</td>
									<td class=data>${menuitem.menuItemKeywordId}</td>
									<td class=data>${menuitem.menuItemParentId}</td>
<%-- 									<td class=data><c:if test="${menuitem.menuItemEnabledFlag == 0}"> --%>
<%-- 											<a href="#activate/${menuitem.menuItemId}">Activate/</a> --%>
<%-- 										</c:if> <c:if test="${menuitem.menuItemEnabledFlag == 1}"> --%>
<%-- 											<a href="#deactivate/${menuitem.menuItemId}">Deactivate/</a> --%>
<%-- 										</c:if> <a href="removemenuitem/${menuitem.menuItemId}.html">Delete</a><a> --%>
<%-- 											| </a><a href="#edit/${menuitem.menuItemId}">Edit</a></td> --%>
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