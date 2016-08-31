<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>

<title>Administrator</title>
   <style>
body  {
    background-image: url("http://laban.rs/img/idx/el_i_bg_2.jpg");
    background-color: #cccccc;
}
</style>


</head>

<body>
		<h2>Welcome Administrator <c:if test="${not empty sessionScope.usersession}">${sessionScope.usersession.name}</c:if> </h2>
		<div>
<p>Select an action from below:</p>
	
	<table style="border-collapse: collapse;">
	    <tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/DoctorsControllerServlet">Doctors list</a></td>
		</tr>
		<tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/newCycle.jsp">Create New Cycle</a></td>
		</tr>
		<tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/AdminAssignVisitor.jsp">Assign visitors-Delete Doctors</a></td>
		</tr>
		
	<!-- <tr>
			<td style="padding: 10px;"><a href="${pageContext.request.contextPath}/deleteDoctors.jsp">Delete Doctors</a></td>
		</tr>--> 
	</table>
<!-- <span style="float:left;">
	<form action="DoctorsControllerServlet" method="post">
	<input type="submit" value="assign visitor" />
    </form>
    </span>
    <span style="float:middle;">
    <form action="DoctorsControllerServlet" method="post">
	<input type="submit" value="create cycle" />
    </form>
    </span>
      -->
    
	<div style="clear: both;"></div>
<p>
<a href="Login_form.html">Logout</a>
</p>
</div>
	 

</body>
</html>