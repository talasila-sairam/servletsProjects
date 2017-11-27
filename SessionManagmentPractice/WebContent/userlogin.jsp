<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='/SessionManag/UrlRewrtng'>
<pre>
EnterName<input type="text" name="uname"><br>
EnterValue<input type="text" name="uval"><br>
submit<input type="submit" >
</pre>
</form>
<%-- <c:url scope="session" value="UrlRewrtng" var="ur"/> --%>
<%
//out.println("this is jsp session id"+session.getId());
String str=response.encodeURL("/SessionManag/UrlRewrng2");
String str1=response.encodeURL("/SessionManag/UrlRewrtng");
System.out.println("jsps encoded url"+str1);
System.out.println("jsps session id"+session.getId());
session.setAttribute("str1",str1);
out.println("<h2><a href="+str+">click</a></h2>");
%>
</body>
</html>