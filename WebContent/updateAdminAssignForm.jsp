<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<title>Update Doctor</title>
<style>
body  {
    background-image: url("http://laban.rs/img/idx/el_i_bg_2.jpg");
    background-color: #cccccc;
}
</style>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2> assign visitor</h2>
		</div>
	</div>
	<div id="container">
	<h3>enter new medical visitor</h3>
		<form action="AdminControllerServlet" method="GET">
	
			<input type="hidden" name="command" value="UPDATE"/>
			<input type="hidden" name="doctorId" value="${THE_DOCTORS.id}"/>
			
			
			
			
				<table>
					<tbody>
					
						<tr>
							<td><label>medical visitor: </label></td>
			                <td><input type="text" name="medical_visitor" 
			                                        VALUE="${THE_DOCTORS.medical_visitor}"> </td>
						</tr>
						
						<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<c:if test="${not empty error}">
									<font color="red">${error}</font>
								</c:if>
							</td>
						</tr>
					</tbody>
	
				</table>
			</form>
			<div style="clear: both;"></div>
<p>
<a href="AdminAssignVisitor.jsp">Back to List</a>
</p>
</div>
	
</body>

</html>