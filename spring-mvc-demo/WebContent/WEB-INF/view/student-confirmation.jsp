<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student COnfirmation</title>
</head>
<body>

	<h3>

		Student FirstName: ${student.firstName} <br>
		<br> Student LastName: ${student.lastName} <br>
		<br> Student Country: ${student.country} <br>
		<br> Student Feverate Language: ${student.fevLang} <br>
		<br> Student OS knoledge:

		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
				<li>test ==> ${temp}</li>
			</c:forEach>
		</ul><br>
		<br>

	</h3>

</body>
</html>