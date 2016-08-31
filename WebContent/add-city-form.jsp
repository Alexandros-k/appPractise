<!DOCTYPE html>
<html>
<head>
<title>Add Doctor</title>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2> new City</h2>
		</div>
	</div>
	<div id="container">
	<h3>Add city</h3>
		<form action="CityControlerCervlet" method="GET">
	
			<input type="hidden" name="command" value="ADD"/>
				<table>
					<tbody>
					
						<tr>
							<td><label>Description: </label></td>
			                <td><input type="text" name="Description" > </td>
						</tr>
						<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
	
				</table>
			</form>
			<div style="clear: both;"></div>
<p>
<a href="CityControlerCervlet">Back to List</a>
</p>
</div>
	
</body>

</html>