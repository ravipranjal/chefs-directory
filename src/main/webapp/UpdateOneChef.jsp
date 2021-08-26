<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Update</title>
    </head>
    <body>
    	<form action="updateDB"> 
	    	<div>
				<h2>Modify and click update </h2>
				<label for="id">Id:</label>
				<input type="text" name="id" value="<c:out value="${chef.id}"/>" id="id" readonly="readonly" />
				<label for="chefname">Chef Name:</label>
				<input type="text" name="chefname" value="<c:out value="${chef.cname}"/>" id="chefname" readonly="readonly" />				
				<label for="address">Address:</label>
				<input type="text" name="address" value="<c:out value="${chef.address}"/>" id="address">
				<label for="phone">Phone:</label>
				<input type="text" name="phone" value="<c:out value="${chef.phone}"/>" id="phone">
				<input type="submit" value="Update">
			</div>
		</form>
		<hr>
		<a href="/"> Home </a> <br>
		<a href="/update"> Back </a>
    </body>
</html>
