<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="mypack.Dept" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Department Search</title>
</head>
<body>
    <h2>Search By Location</h2>
    <form action="SearchServ" method="post">
        <label for="location">Enter Location:</label>
        <input type="text" id="location" name="location" />
        <input type="submit" value="Search" />
    </form>
    <h3>Search Results:</h3>
    <c:choose>
        <c:when test="${not empty depts}">
            <c:forEach var="dept" items="${depts}">
                <p>Department Number: ${dept.deptno} | Department Name: ${dept.dname} | Location: ${dept.loc}</p>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>No results found.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
