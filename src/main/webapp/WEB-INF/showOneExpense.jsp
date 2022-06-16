<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS Link -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
<!-- <!-- Bootstrap Link -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h2>Expense Details</h2> <a href="/expenses">Go Back</a>
		<p>Expense Name: ${expense.name}</p>
		<p>Expense Description: ${expense.description}</p>
		<p>Vendor: ${expense.vendor}</p>
		<p>Amount Spent: $${expense.amount}</p>
	</div>
</body>
</html>