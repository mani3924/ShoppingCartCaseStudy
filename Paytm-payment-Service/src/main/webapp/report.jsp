<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Report</title>
</head>
<body>
	<form action="/pgresponse" method = "post">
	<tbody>
	<tr th:each="entry: ${parameters}">
		 <td th:text="${entry.key} + ' : ' + ${entry.value}"></td>
		
	</tr>
	</tbody>
</body>
</html>