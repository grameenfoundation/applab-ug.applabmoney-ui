<%@ include file="include.jsp" %>

<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now <c:out value="${now}"/></p>
    
    <a href ="adminui.html"> Administrator Console Login</a></br>
    <a href ="auilanding.html">Password Settings</a></br>
    <a href ="auimsisdnsettings.html">MSISDN Settings</a></br>
    <a href ="auitransactionsettings.html">Transaction Settings</a></br>
    <a href ="auimessagesettings.html">Message Settings</a></br>
    <a href ="auilanguagesettings.html">Language Settings</a></br>
    <a href ="auiaccountsconfiguration.html">Accounts Configuration</a></br>
    <a href ="auimemogroupsconfiguration.html">Memo Groups Configuration</a></br>
    <a href ="auimobilendcconfiguration.html.html">Mobile NDC Configuration</a></br>
  </body>
</html>