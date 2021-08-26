<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Delete</title>
    </head>
    <body>
    	<form action="deleteDB"> 
	    	<div>
				<h2>Press delete to delete</h2>
				<label for="id">Id:</label>
				<input type="text" name="id" value="<c:out value="${chef.id}"/>" id="id" readonly="readonly" />
				<label for="chefname">Chef Name:</label>
				<input type="text" name="chefname" value="<c:out value="${chef.cname}"/>" id="chefname" readonly="readonly" />				
				<label for="address">Address:</label>
				<input type="text" name="address" value="<c:out value="${chef.address}"/>" id="address" readonly="readonly">
				<label for="phone">Phone:</label>
				<input type="text" name="phone" value="<c:out value="${chef.phone}"/>" id="phone" readonly="readonly">
				<input type="submit" value="Delete">
			</div>
		</form>
		<hr>
		<a href="/"> Home </a> <br>
		<a href="/delete"> Back </a>
    </body>
</html>
