<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:errors path="customer1.*" />
	<h2>Add Delivery Address</h2>
	<form action="addPaymentDetails" method = "post">
		<table>
			<tr>
				<td>Full Name  </td> <td> <input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Phone Number </td> <td> <input type= "text" name = "phonenumber" /></td>
			</tr>
			<tr>
				<td>Pincode </td> <td>  <input type= "text" name = "pincode" /></td>
			</tr>
			<tr>
				<td>State  </td> <td> <input type= "text" name = "state" /></td>
			</tr>
			<tr>
				<td>City  </td> <td> <input type= "text" name = "city" /></td>
			</tr>
			<tr>
				<td>Building Name  </td> <td> <input type= "text" name = "buildingname" /></td>
			</tr>
			<tr>
				<td>Road Name  </td> <td> <input type= "text" name = "roadname" /></td>
			</tr>
			<tr><td><input type="submit"  value= "Next"/></td></tr>
			
		</table>
</body>
</html>