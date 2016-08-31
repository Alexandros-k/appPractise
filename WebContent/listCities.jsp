<%@ page import="java.util.*,appPractise.*"%>
 
<!DOCTYPE html>
<html>
<head>

<title>Cities test</title>
</head>
<%
//get the cities from the request object (send by servlet)
List<Cities> theCities = 
            (List<Cities>)request.getAttribute("CITIES_LIST");

%>
<body>
<div id="wrapper">
<div id="header">
<h2>cities testing</h2>
</div>
</div>

<div id="container">
<div id="content">
<!-- put new button add city -->
<input type="button" value="Add City"
       onclick="window.location.href='add-city-form.jsp';return false;"
      class="add-city-button"
       />
<table>

<tr>


<th>description </th>

</tr>
<% for(Cities tempCities : theCities) {%>
<tr>
<td><%=tempCities.getCITY_ID() %></td>
<td><%=tempCities.getDESCRIPTION() %></td>
</tr>
<%}%>

</table>

</div>


</div>


</body>
</html>