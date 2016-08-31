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
			<h2> Update Doctor</h2>
		</div>
	</div>
	<div id="container">
	<h3>enter new info</h3>
		<form action="searchDoctors" method="GET">
	
			<input type="hidden" name="command" value="UPDATE"/>
			<input type="hidden" name="doctorId" value="${THE_DOCTORS.id}"/>
			
			<c:url var="deleteLink" value="AdminControllerServlet">
<c:param name="command" value="DELETE"/>
<c:param name="doctorId" value="${sdoctors.id}"/>
</c:url>
			
			
				<table>
					<tbody>
						<tr>
							<td><label>Name: </label></td>
			                <td><input type="text" name="name" 
			                           VALUE="${THE_DOCTORS.name}"> </td>
						</tr>
						<tr>
							<td><label>Specialty: </label></td>
			                <td><select name="specialty" VALUE="${THE_DOCTORS.specialty}">
                          <option>surgeon</option>
                          <option>pathologos</option>
                            <option>pediatrician</option>
							<option>pneumonologist</option>
							</select> </td>
						</tr>
						<tr>
							<td><label>Address: </label></td>
			                <td><input type="text" name="address"
			                VALUE="${THE_DOCTORS.address}" > </td>
						</tr>
						<tr>
							<td><label>Phone: </label></td>
			                <td><input type="text" name="phone" 
			                       VALUE="${THE_DOCTORS.phone}"> </td>
						</tr>
						
						<tr>
							<td><label>City: </label></td>
			                <td><select name="city" VALUE="${THE_DOCTORS.city}">
							<option>Athens</option>
						    <option>Peiraeous</option>
							<option>Marousi</option>
							<option>Glyfada</option>
							</select> </td>
						</tr>
						<tr>
							<td><label>Geographical_area: </label></td>
			                <td><select name="geographical_area" VALUE="${THE_DOCTORS.geographical_area}">
							<option>Attiki</option>
							<option>Thesalloniki</option>
							<option>Crete</option>
							<option>Patra</option>
							</select> </td>
						</tr>
						<tr>
							<td><label>Institution: </label></td>
			                <td><select name="institution" VALUE="${THE_DOCTORS.institution}">
							<option>tzanio</option>
							<option>Geniko Nikaias</option>
							<option>Geniko Athinas</option> 
							</select></td>
						</tr>
						<tr>
							<td><label>Position: </label></td>
			                <td><input type="text" name="position" 
			                                        VALUE="${THE_DOCTORS.position}"> </td>
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
<a href="searchDoctors">Back to List</a>
</p>
</div>
	
</body>

</html>