<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Imenik</title>
</head>
<body>
	<h1>Imenik</h1>

	<table class="table">
		<tr>
			<th>Ime</th>
			<th>Priimek</th>
			<th>Oddelek</th>
			<th>Interna telefonska številka</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="row" items="${zaposleniList}">
			<tr>
				<td><c:out value="${row.getIme()}"></c:out></td>
				<td><c:out value="${row.getPriimek()}"></c:out></td>
				<td><c:out value="${row.getOddelek()}"></c:out></td>
				<td><c:out value="${row.getInterna_telefonska_stevilka()}"></c:out></td>
				<td><a href="/Imenik/popravi?id=${row.getId()}"> <span
						class="glyphicon glyphicon-pencil" ></span>
				</a></td>
				<td><a href="/Imenik/izbrisi?id=${row.getId()}"> <span
						class="glyphicon glyphicon-remove" ></span>
				</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/Imenik/dodaj">Dodaj zaposlenega</a>
</body>
</html>