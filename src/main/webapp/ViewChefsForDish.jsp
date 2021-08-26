<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>All chefs</title>
    </head>
    <body>
    	<hr>
    	<h2> All Chefs for dish: ${dishname} </h2>
    	<hr>
		<table border="1">
		  <thead>
		    <tr>
		      <th>Chef Name</th>
		      <th>Address</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${chefsfordish}" var="value">
		      <tr>
		        <td>
		          <c:out value="${value.cname}"/>
		        </td>
		       	<td>
		          <c:out value="${value.address}"/>
		        </td>
		      </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<a href="/">Home</a><br>
		<a href="/listdishesforchef">Back</a><br>
    </body>
</html>