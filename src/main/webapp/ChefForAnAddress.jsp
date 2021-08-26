<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Chef for address</title>
    </head>
    <body>
    	
    	<hr>
    	The chef who lives at <b>${address}</b> is <b>${chef}.</b>
    	<hr>

		<a href="/">Home</a><br>
		<a href="/getcheffromaddress">Back</a><br>
    </body>
</html>