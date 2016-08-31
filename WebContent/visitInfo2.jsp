<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html> 
<html>
<head>
<style>
body  {
    background-image: url("http://laban.rs/img/idx/el_i_bg_2.jpg");
    background-color: #cccccc;
}
table, th, td {
    border: 1px solid black;
}
{
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
 tr:nth-child(even){background-color: #f2f2f2;}
 tr:hover {background-color: #ddd;}
 th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4B0082;
    color: white;
}
</style>
<title>Visits List</title>
</head>


<body>
<div id="wrapper">
<div id="header">
<h2>Visits List</h2>
</div>
</div>

<div id="container">
<div id="content">

<form action="DoctorsControllerServlet" method="GET">
	
			<input type="hidden" name="command" value="LIST-VISITS"/>

    <c:if test="${not empty LIST-VISITS}">	
<table style="width:100%">
<tr>
<th>id</th>
<th>Doctors id</th>
<th>Users id</th>
<th>Date</th>
<th>Comments</th>

</tr>

<c:forEach var="sdoctors" items="${LIST-VISITS }">
<tr>

<td><${tempVisits.Id}</td>
<td>${tempVisits.DoctorId}</td>
<td>${tempVisits.UserId}</td>
<td>${tempVisits.Date}</td>
<td>${tempVisits.Comments}</td>

</tr>




</c:forEach>

</table>
</c:if>
		<div style="clear: both;"></div>
<p>
<a href="medvistab.jsp">start page</a>
</p>
</form>
</div>


</div>

</body>
</html>