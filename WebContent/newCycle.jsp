<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Cycle</title>
</head>
<body>
	<h2>Create New Cycle</h2>
	<form action="${pageContext.request.contextPath}/createCycle" method="post">
		<table>
			<tr>
				<td>From Date: </td>
				<td><input type="text" name="fromDate" value="${param.fromDate}"/></td>
				<td>
					<c:if test="${not empty fromDateError}">
						<font color="red">${fromDateError}</font>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>To Date: </td>
				<td><input type="text" name="toDate" value="${param.toDate}"/></td>
				<td>
					<c:if test="${not empty toDateError}">
						<font color="red">${toDateError}</font>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create" /></td>
			</tr>
		</table>
	</form>
</body>
</html>