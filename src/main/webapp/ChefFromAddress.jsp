<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Select address</title>
    </head>
    <body>
    	<form action="viewchefforaddress"> 
	    	<div>
				<h2>Please select an address ans press show</h2>
				<label for="address">Address:</label>
				<select name="address" id="address"> 
					<option selected="selected">-- Select --</option>
					<c:forEach items="${allchefs}" var="value">
					<option><c:out value="${value.address}"/></option>
					</c:forEach>
				</select>
				<input type="submit" value="Show">
				
			</div>
		</form>
		<hr>
		<a href="/">Home</a>
    </body>
</html>
