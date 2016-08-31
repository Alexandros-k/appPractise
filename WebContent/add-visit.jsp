<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Add Visit</title>
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
			<h2> Add Visit</h2>
		</div>
	</div>
	<div id="container">
	<h3>New Visit</h3>
		<form action="DoctorsControllerServlet" method="GET">
	
			<input type="hidden" name="command" value="ADD-VISIT"/>
			<input type="hidden" name="doctorId" value="${param.doctorId}"/>
			
				<table>
					<tbody>
						<tr>
							<td>Doctor:</td>
			                <td colspan="2">${doctorName}</td>
						</tr>
						
						
						<tr>
							<td><label>Date of Visist: </label></td>
			                <td><input type="text" name="date" value="${param.date}"> </td>
			                <td>
			                <c:if test="${not empty dateVisitError}">
								<font color="red">${dateVisitError}</font>
							</c:if>
			                </td>
						</tr>
						<tr>
							<td><label>Cycle:</label></td>
							<td>
								<select name="cycle">
									<c:forEach var="cycle" items="${cycles}">
										<c:choose>
							                <c:when test="${param.cycle eq cycle.cycleId}">
				                          		<option selected="selected" value="${cycle.cycleId}">${cycle.cycleDescription}</option>
				                          	</c:when>
				                          	<c:otherwise>
				                          		<option value="${cycle.cycleId}">${cycle.cycleDescription}</option>
				                          	</c:otherwise>
		                          		</c:choose>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td><label>Comments: </label></td>
			                <td colspan="2"><input type="text" name="comments" value="${param.comments}"> </td>
						</tr>
						<tr>
						<td></td>
						<td colspan="2"><input type="submit" value="Save" class="save"/></td>
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
<a href="medvistab.jsp">start page</a>
</p>
</div>
	
</body>

</html>