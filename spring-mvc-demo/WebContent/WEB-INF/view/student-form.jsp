
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">
First Name: <form:input path="firstName"/><br><br>
Last Name : <form:input path="lastName"/><br><br>
Country : 

<%-- <form:select path="country">
<form:option value="India" lable="India"></form:option>
<form:option value="Austelia" lable="Austelia"></form:option>
<form:option value="Nepal" lable="Nepal"></form:option>
<form:option value="Isril" lable="Isril"></form:option>

</form:select><br><br> --%>

<form:select path="country">
<form:options items="${student.countryOption}"/>
</form:select>

<br><br>

Programming Language:
Java<form:radiobutton path="fevLang" value="Java"/>
Python<form:radiobutton path="fevLang" value="Python"/>
C++<form:radiobutton path="fevLang" value="C++"/>
JavaScript<form:radiobutton path="fevLang" value="JavaScript"/>

<br><br>

Operating Systems:
Windows<form:checkbox path="operatingSystems" value="windows"/>
Linux<form:checkbox path="operatingSystems" value="linux"/>
MacOS<form:checkbox path="operatingSystems" value="macos"/>

<input type="submit" value="Submit">
</form:form>

</body>
</html>