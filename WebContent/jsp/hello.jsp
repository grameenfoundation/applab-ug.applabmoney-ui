<%@ include file="include.jsp"%>

<html>
<head>
<title>Hello :: Spring Application</title>
</head>
<body>
	<h1>Hello - Spring Application</h1>
	<p>
		Greetings, it is now
		<c:out value="${now}" />
	</p>

	<a>USSD Processing Engine Setup Menu</a>
	</br>
	</br>
	<a href="listussdmenuitems.html"> USSD Menu Items Management</a>
	</br>
	<a href="listussdtransactionkeywords.html"> Transaction Keyword
		Management</a>
	</br>
	<a href="listussdpredefinputitems.html"> Predefined Input Items
		Management</a>
	</br>
	<a href="listussdpredefinputs.html"> Predefined Input Management</a>
	</br>
	<a href="listussdkeywordsteps.html"> Keyword Steps Management</a>
	</br>
	</br>

	<a>Admin UI parked!! :-)</a>
	<br>
	<br>
	<a href="uilogin.html"> Administrator Console Login</a>
	</br>
	<a href="viewsystemconfiguration.html">System Configuration</a>
	</br>
	<a href="listmobilendc.html">Mobile NDC Configuration</a>
	</br>
	<a href="listusers.html"> User Management</a>
	</br>
	<a href="listaccounttypes.html"> Account Type Management</a>
	</br>
	<a href="listlanguages.html"> Language Configuration</a>
	</br>
	<a href="listmessages.html"> Message Management</a>
	</br>
	<a href="listglobalkeywordcharges.html"> Global Keyword Charge Setup</a>
	</br>
	<a href="listmemogroups.html"> Memo Groups</a>
	</br>
	<a href="viewamlbarringsettings.html"> AML Settings</a>
	</br>
	<a href="viewmetomesetup.html"> Me2Me</a>
    </br>
    <a href="viewzimbasetup.html">Zimba</a>
    </br>
	


</body>
</html>