<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uredi</title>
</head>
<body>

	<!-- ${pageContext.request.contextPath}/ object="${zaposleni}" commandName="somedata"-->
	<form:form class="form-horizontal" method="post" action="dodaj"
		modelAttribute="zaposleni">
		<form:input path="id" name="id" type="hidden"
			value="${zaposleni.getId()}" />
		<div class="form-group">
			<label for="ime"  class="col-sm-2 control-label">Ime</label>
			<div class=" col-sm-8">
				<form:input class="form-control" path="ime" name="ime" type="text"
					value="${zaposleni.getIme()}" />
				<br />
				<p class="text-danger"><form:errors path="ime"/></p>
			</div>
		</div>
		<div class="form-group" >
			<label for="priimek" class="col-sm-2 control-label">Priimek</label>
			<div class="col-sm-8">
				<form:input class="form-control" path="priimek" name="priimek"
					type="text" value="${zaposleni.getPriimek()}" />
				<br />
				<p class="text-danger"><form:errors path="priimek" /></p>
			</div>
		</div>
		<div class="form-group">
			<label for="oddelek"  class="col-sm-2 control-label">Oddelek</label>
			<div class="col-sm-8">
				<form:select class="form-control" path="oddelek" name="oddelek">
					<option value="">Izberite oddelek</option>
					<option value="Finance"
						${zaposleni.getOddelek().equals("Finance") ? "selected"
							: ""}>Finance</option>
					<option value="Prodaja"
						${zaposleni.getOddelek().equals("Prodaja") ? "selected"
							: ""}>Prodaja</option>
					<option value="Razvoj"
						${zaposleni.getOddelek().equals("Razvoj") ? "selected"
							: ""}>Razvoj</option>
					<option value="Administracija"
						${zaposleni.getOddelek().equals("Administracija") ? "selected"
							: ""}>Administracija</option>
				</form:select>
				<br />
				<p class="text-danger"><form:errors path="oddelek" /></p>
			</div>
		</div>
		<div class="form-group">
			<label for="interna_telefonska_stevilka"  class="col-sm-2 control-label">Interna telefonska
				številka</label>
			<div class="col-sm-8">
				<form:input class="form-control" path="interna_telefonska_stevilka"
					name="interna_telefonska_stevilka" type="text"
					value="${zaposleni.getInterna_telefonska_stevilka()}" />
				<br />
				<p class="text-danger"><form:errors path="interna_telefonska_stevilka"/></p>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input value="Shrani" type="submit" class="btn btn-default" />
			</div>
		</div>
	</form:form>
</body>
</html>