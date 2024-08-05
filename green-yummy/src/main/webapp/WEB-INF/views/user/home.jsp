<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <h1>User Home</h1>
    <p>Only logged in users can view this page.</p>
    <c:if test="${not empty user}">
    <table>
    	<tr>
    		<td>UserId</td>
    		<td>${user.id}</td>
    	</tr>
    	<tr>
    		<td>Password</td>
    		<td>${user.password}</td>
    	</tr>
    	<tr>
    		<td>Name</td>
    		<td>${user.name}</td>
    	</tr>
    	<tr>
    		<td>Email</td>
    		<td>${user.email}</td>
    	</tr>
    </table>
    </c:if>
    <c:if test="${empty user}">
        <p>No user information available.</p>
    </c:if>
    <form action="/logout" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    	<input type ="submit" value="로그아웃">
    </form>
    
</body>
</html>