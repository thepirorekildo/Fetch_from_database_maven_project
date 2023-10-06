<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.rek.web.model.Alien"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<br>
		<%
			Alien a1 = (Alien)request.getAttribute("alien");
		
			out.println(a1);
		%>
</body>
</html>