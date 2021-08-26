<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>All Dishes</title>
    </head>
    <body>
    	<form action="listchefsfordish"> 
	    	<div>
				<h2>Please select a dish and press Show chefs</h2>
				<label for="dishname">Dish:</label>
				<select name="dishname" id="dishname"> 
					<option selected="selected">-- Select --</option>
					<c:forEach items="${alldishes}" var="value">
					<option><c:out value="${value.dname}"/></option>
					</c:forEach>
				</select>
				<input type="submit" value="Show chefs">
				
			</div>
		</form>
		<hr>
		<a href="/">Home</a>
    </body>
</html>