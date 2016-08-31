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
<title>Visits List</title>
</head>
<% List<Visits> visits=(List<Visits>)request.getAttribute("VISIT_LIST");
%>
<body>
<div id="wrapper">
<div id="header">
<h2>Visits List</h2>
</div>
</div>

<div id="container">
<div id="content">

    
<table style="width:100%">
<tr>
<th>id</th>
<th>Doctors id</th>
<th>Cycle Id</th>
<th>Date</th>
<th>Comments</th>

</tr>

<% for(Visits tempVisits : visits) {%>
<tr>

<td><%=tempVisits.getId() %></td>
<td><%=tempVisits.getDoctorId() %></td>
<td><%=tempVisits.getCycleId() %></td>
<td><%=tempVisits.getDateFormated() %></td>
<td><%=tempVisits.getComments() %></td>

</tr>


<%}%>



</table>
		<div style="clear: both;"></div>
<p>
<a href="medvistab.jsp">start page</a>
</p>
</div>


</div>

</body>
</html>