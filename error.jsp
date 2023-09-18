<% 
String message = pageContext.getException().getMessage();
String exception = pageContext.getException().getClass().toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Exception</title>
</head>
<body>
<h2>Exception mathematic operation impossible</h2>
<p>Type: <%=exception%></p>
<p>message: <%=message%></p>
</body>
</html>