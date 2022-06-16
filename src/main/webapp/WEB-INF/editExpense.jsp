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
		<h2>Add an expense:</h2><a href="/expenses">Go Back</a>
	
		<form:form action="/expenses/${expense.id}/update" method='POST' modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
<%-- 		<input type="hidden" name="id" value="${expense.id}"> --%>
		
		 <div class="mb-2 mt-3">
			<form:label path="name">Expense Name: </form:label>
			<form:input type="text" path="name"/>
			<form:errors path="name" class="text-danger"/>
		</div> 
		
		<div class="mb-2">
			<form:label path="vendor">Vendor: </form:label>
			<form:input type="text" path="vendor"/>
			<form:errors path="vendor" class="text-danger"/>
		</div>
		
		<div class="mb-2">
			<form:label path="amount">Amount: </form:label>
			<form:input type="number" path="amount" min="5"/>
			<form:errors path="amount" class="text-danger"/>
		</div>
		
		<div class="mb-2">
			<form:label path="description">Description: </form:label>
			<form:textarea path="description" rows="2" cols="20"/>
			<form:errors path="description" class="text-danger"/>
		</div>
		
		<button class="btn btn-primary">Submit</button>
		</form:form>
	
	</div>

</body>
</html>