<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Select</title>
    </head>
    <body>
    	<form action="updateforonechef"> 
	    	<div>
				<h2>Please select a chef to update</h2>
				<label for="chefname">Chef Name:</label>
				<select name="chefname" id="chefname"> 
					<option selected="selected">-- Select --</option>
					<c:forEach items="${allchefs}" var="value">
					<option><c:out value="${value.cname} -- id:${value.id}"/></option>
					</c:forEach>
				</select>
				<input type="submit" value="Update">
				
			</div>
		</form>
		<hr>
		<a href="/">Home</a>
    </body>
</html>
