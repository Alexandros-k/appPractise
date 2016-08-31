<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>

<title>medical visitor form</title>
   <style>
body  {
    background-image: url("http://laban.rs/img/idx/el_i_bg_2.jpg");
    background-color: #cccccc;
}
</style>

</head>

<body>
<div>


	<H2>
		Welcome  <c:if test="${not empty sessionScope.usersession}">${sessionScope.usersession.name}</c:if>!
	</H2>
	
	<p>Select an action from below:</p>
	
	<table style="border-collapse: collapse;">

		<tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/add-doctor-form.jsp">Create New Doctor</a></td>
		</tr>
		<tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/searchDoctor.jsp">Search and update Doctors</a></td>
		</tr>
		<tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/DoctorsControllerServlet?command=LIST-VISITS">See Visits info</a></td>
		</tr>
	
	
	</table>
	<!-- <form action="DoctorsControllerServlet" method="post">
	<input type="submit" value="add doctor" />
	   </form>

    <span style="float:middle;">
   
    <form action="searchDoctors" method="post">
	<input type="submit" value="search doctor" />
    </form>
    
         
    </span>
     <span style="float:middle;">
    <form action="DoctorsControllerServlet" method="post">
	<input type="submit" value="visits info" />
    </form>
    </span>
     -->
    
<a href="Login_form.html">Logout</a>
</div>

</body>
</html>