<%@ page import="java.util.*,appPractise.*"%>
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
<title>Doctors List</title>
</head>
<% List<doctors>theDoctors=
                       (List<doctors>)request.getAttribute("doctors_list");
%>
<body>
<div id="wrapper">
<div id="header">
<h2>Doctors List</h2>
</div>
</div>

<div id="container">
<div id="content">

<form action="DoctorsControllerServlet" method="POST">
<input type="hidden" name="command" value="LIST"/>
    
<table style="width:100%">
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
</tr>
<% for(doctors tempDoctors : theDoctors) {%>
<tr>

<td><%=tempDoctors.getId() %></td>
<td><%=tempDoctors.getName() %></td>
<td><%=tempDoctors.getSpecialty() %></td>
<td><%=tempDoctors.getAddress() %></td>
<td><%=tempDoctors.getPhone() %></td>
<td><%=tempDoctors.getCity() %></td>
<td><%=tempDoctors.getGeographical_area() %></td>
<td><%=tempDoctors.getInstitution() %></td>
<td><%=tempDoctors.getPosition() %></td>
<td><%=tempDoctors.getMedical_visitor() %></td>
</tr>


<%}%>


</table>

</form>
		<div style="clear: both;"></div>
<p>
<a href="admin.jsp">start page</a>
</p>
</div>


</div>

</body>
</html>