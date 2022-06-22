
<%@page import="java.util.List"%>
<%@page import="modelo.Flores"%>
<%@page import="modeloDAO.FloresDAO"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kdam+Thmor+Pro&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="contenedor">
		<center>
			<h1>FLORES</h1>
		</center>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">NOMBRE DE FLOR</th>
					<th class="text-center">STOCK</th>
					<th class="text-center">VALOR POR UNIDAD</th>
					<th class="text-center">FECHA DE INGRESO</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<%
			FloresDAO dao = new FloresDAO();
			List<Flores> list = dao.listar();
			Iterator<Flores> iter = list.iterator();
			Flores flor = null;
			while (iter.hasNext()) {
				flor = iter.next();
			%>
			<tbody>
				<tr>
					<td class="text-center"><%=flor.getId() %></td>
					<td class="text-center"><%=flor.getNombre_flor() %></td>
					<td class="text-center"><%=flor.getStock() %></td>
					<td class="text-center"><%=flor.getValor_unidad() %></td>
					<td class="text-center"><%=flor.getFecha_ingreso() %></td>
					<td class="text-center"><a class="btn btn-warning"
						href="Controlador?accion=editar&id=<%=flor.getId()%>">Edit</a> <a
						class="btn btn-danger"
						href="Controlador?accion=eliminar&id=<%=flor.getId() %>">Remove</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<center>
			<a class="btn btn-success" href="Controlador?accion=add">Agregar
				Nuevo</a> <a class="btn btn-success" href="index2.jsp">volver</a>
		</center>
	</div>
</body>
</html>

<style>
body {
	background: url('Flores/3.jpg');
	background-size: 100%;
	background-repeat: no-repeat;
	background-position: top center;
	font-family: 'Kdam Thmor Pro', sans-serif;
}

.contenedor {
	width: 60%;
	height: auto;
	background: url('Flores/3.jpg');
	position: absolute;
	top: 40%;
	left: 25%;
	margin-top: -100px;
	margin-left: -100px;
	padding: 25px;
	border-radius: 25px;
	border: 1px solid black;
	margin-button: 34px;
}
</style>