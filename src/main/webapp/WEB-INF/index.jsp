<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>

<!-- CSS Link -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
<!-- <!-- Bootstrap Link -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<table class="table">
			<tr>
				<th scope="col">Expense</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Actions</th>
				<th scope="col"></th>
			</tr>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
		        <tr>
			        <td><a href="/expenses/${expense.id}/show"><c:out value="${expense.name}"></c:out></a></td>
			        <td><c:out value="${expense.vendor}"></c:out></td>
			        <td>$<c:out value="${expense.amount}"></c:out></td>
			        <td><a href="/expenses/${expense.id}/edit">Edit</a></td>
			        <td><form action="/expenses/${expense.id}/delete" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete" class="btn btn-danger">
					</form>
					</td>			  
		        </tr>
		    	</c:forEach>
				
			</tbody>		
		</table>	
	</div>
	<div class="container">
	<h2>Add an expense:</h2>
	
		<form:form action="/expenses/create" method='POST' modelAttribute="expense">
		
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