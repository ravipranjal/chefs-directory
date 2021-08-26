<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Create</title>
    </head>
    <body>
    	<form action="createDB"> 
	    	<div>
				<h2> Create </h2>
				<label for="chefname">Chef Name:</label>
				<input type="text" name="chefname" placeholder="Ex: Mark" id="chefname">
				<label for="address">Address:</label>
				<input type="text" name="address" placeholder="Ex: 314 West Avenue" id="address">
				<label for="phone">Phone:</label>
				<input type="text" name="phone" placeholder="Ex: 000-000-0000" id="phone">
				<input type="submit" value="Create">
			</div>
		</form>
		<hr>
		<a href="/">Home</a>
    </body>
</html>