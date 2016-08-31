<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<title>Add Doctor</title>
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
			<h2> Add Doctor</h2>
		</div>
	</div>
	<div id="container">
	<h3>New Doctor</h3>
		<form action="DoctorsControllerServlet" method="GET">
	
			<input type="hidden" name="command" value="ADD"/>
			
			
				<table>
					<tbody>
						<tr>
							<td><label>Name: </label></td>
			                <td><input type="text" name="name" value="${param.name}"> </td>
						</tr>
						<tr>
							<td><label>Specialty: </label></td>
			                <td><select name="specialty" >
			                <c:choose>
			                <c:when test="${param.specialty eq 'surgeon'}">
                          		<option selected="selected">surgeon</option>
                          	</c:when>
                          	<c:otherwise>
                          		<option >surgeon</option>
                          	</c:otherwise>
                          </c:choose>
                          <c:choose>
			                <c:when test="${param.specialty eq 'pathologos'}">
                          		<option selected="selected">pathologos</option>
                          	</c:when>
                          	<c:otherwise>
                          		<option >pathologos</option>
                          	</c:otherwise>
                          </c:choose>
                          <c:choose>
			                <c:when test="${param.specialty eq 'pediatrician'}">
                          		<option selected="selected">pediatrician</option>
                          	</c:when>
                          	<c:otherwise>
                          		<option >pediatrician</option>
                          	</c:otherwise>
                          </c:choose>
							<c:choose>
			                <c:when test="${param.specialty eq 'pneumonologist'}">
                          		<option selected="selected">pneumonologist</option>
                          	</c:when>
                          	<c:otherwise>
                          		<option >pneumonologist</option>
                          	</c:otherwise>
                          </c:choose>

							</select> </td>
						</tr>
						<tr>
							<td><label>Address: </label></td>
			                <td><input type="text" name="address" value="${param.address}"> </td>
						</tr>
						<tr>
							<td><label>Phone: </label></td>
			                <td><input type="text" name="phone" value="${param.phone}"> </td>
						</tr>
						
						<tr>
							<td><label>City: </label></td>
			                <td><select name="city">
							<option>Athens</option>
						    <option>Peiraeous</option>
							<option>Marousi</option>
							<option>Glyfada</option>
							</select> </td>
						</tr>
						<tr>
							<td><label>Geographical_area: </label></td>
			                <td><select name="geographical_area">
							<option>Attiki</option>
							<option>Thesalloniki</option>
							<option>Crete</option>
							<option>Patra</option>
							</select> </td>
						</tr>
						<tr>
							<td><label>Institution: </label></td>
			                <td><select name="institution">
			                
							<option>tzanio</option>
							<option>Geniko Nikaias</option>
							<option>Geniko Athinas</option> 
							</select></td>
						</tr>
						<tr>
							<td><label>Position: </label></td>
			                <td><input type="text" name="position" value="${param.position}"> </td>
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
<a href="medvistab.jsp">Back to List</a>
</p>
</div>
	
</body>

</html>