<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE>
<html>
<head>
<title>Search Doctor</title>
<style>
body  {
     background-image: url("http://laban.rs/img/idx/el_i_bg_2.jpg");
    background-color: #cccccc;
    
   }
   
td, th {
	padding: 10px;
	text-align: center;
	border: 1px solid grey;
}

</style>
</head>


<body>

	<div style="width: 400px; margin-top: 100px;">
           <form method="POST" action="searchDoctors">
			Search by name: <input type="text" name="name" value="${param.name}"/>
		<input type="submit" value="Find" style="margin-left: 10px;"/><br /> 
		</form>
	</div>

<c:if test="${not empty LIST_SEARCHED_DOCTORS}">	
<table style="border: 1px solid grey; border-collapse: collapse;" >
<tr>
<th>id</th>
<th>name</th>
<th>specialty</th>
<th>address</th>
<th>phone</th>
<th>city</th>
<th>geographical_area</th>
<th>institution</th>
<th>position</th>
<th>medical_visitor</th>
<th>edit</th>
</tr>
<c:forEach var="sdoctors" items="${LIST_SEARCHED_DOCTORS }">
<c:url var="updateDocLink" value="searchDoctors">
<c:param name="command" value="LOAD"/>
<c:param name="doctorId" value="${sdoctors.id}"/>
</c:url>
<c:url var="addVisitLink" value="DoctorsControllerServlet">
<c:param name="command" value="NEW-VISIT"/>
<c:param name="doctorId" value="${sdoctors.id}"/>
</c:url>



<tr>

<td>${sdoctors.id}</td>
<td>${sdoctors.name}</td>
<td>${sdoctors.specialty}</td>
<td>${sdoctors.address}</td>
<td>${sdoctors.phone}</td>
<td>${sdoctors.city}</td>
<td>${sdoctors.geographical_area}</td>
<td>${sdoctors.institution}</td>
<td>${sdoctors.position}</td>
<td>${sdoctors.medical_visitor}</td>
<td><a href="${updateDocLink}">Update</a>&nbsp;&nbsp;<a href="${addVisitLink}">Add Visit</a></td>



</tr>


</c:forEach>


</table>
</c:if>

	<div style="clear: both;"></div>
	<p>
		<a href="medvistab.jsp">start page</a>
	</p>

</body>
</html>