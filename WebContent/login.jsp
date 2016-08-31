<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url("http://laban.rs/img/idx/el_i_bg_2.jpg");
	background-color: #cccccc;
	
}
<%
	String errorMessage = (String)request.getAttribute("error");
	%>

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIS Login</title>
</head>
<body>
	<div
		style="width: 400px; margin-top: 100px;">
		<form method="post" action="${pageContext.request.contextPath}/Login">
			Username: <input type="text" name="username" /><br /> 
			Password: <input type="password" name="password" /><br /> 
<%if(errorMessage!=null) { %>
		<font color="red"><%=errorMessage %></font><br/>
<% }%>
			<input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>