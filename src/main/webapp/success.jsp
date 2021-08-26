<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Create</title>
    </head>
    <body>
 		<hr>
 		<h2> Sucess!! </h2>
 		<hr>
		<a href="/">Home</a><br>
		<a href="<c:out value="${back}"/>">Back</a>
    </body>
</html>