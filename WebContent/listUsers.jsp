<%@ page import="java.util.*,appPractise.*"%>
<!DOCTYPE html>
<html>
<head>

<title>Hello User</title>
</head>
<%
	//get the users from the request object (send by servlet)
	List<Users> theUsers = (List<Users>) request.getAttribute("USERS_LIST");
%>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>users testing</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>

				<tr>


					<th>id</th>
					<th>type</th>
					<th>name</th>
					<th>username</th>
					<th>password</th>


				</tr>
				<%
					for (Users tempUsers : theUsers) {
				%>
				<tr>
					<td><%=tempUsers.getId()%></td>
					<td><%=tempUsers.getType()%></td>
					<td><%=tempUsers.getName()%></td>
					<td><%=tempUsers.getUserName()%></td>
					<td><%=tempUsers.getPassWord()%></td>
				</tr>
				<%}%>

			</table>

		</div>


	</div>



</body>
</html>