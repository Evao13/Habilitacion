<%@page import="modeloDAO.FloresDAO"%>
<%@page import="modelo.Flores"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
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
	<div class="container">

		<div>
			<%
			FloresDAO dao = new FloresDAO();
			int id = Integer.parseInt((String) request.getAttribute("idper"));
			Flores f = (Flores) dao.list(id);
			%>
			<center>
				<h1>Modificar Flor</h1>
			</center>
			<form action="Controlador">
			
				Nombre de flor:<br> <input class="form-control" type="text" name="txtnombre" value="<%=f.getNombre_flor() %>"><br> 
					
				Stock: <br> <input class="form-control" type="text" name="txtstock" value="<%=f.getStock()%>"><br>
				
				Valor por unidad: <br> <input class="form-control" type="text" name="txtvalor" value="<%=f.getValor_unidad()%>"><br>

				<center>
					<input type="hidden" name="txtid" value="<%=f.getId()%>"> 
					<input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
				</center>
				<br>
				<center>
					<a class="btn btn-primary" href="Controlador?accion=listar">Regresar</a>
				</center>
			</form>
		</div>

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

.container {
	width: 60%;
	height: 70%;
	background: url('Flores/2.jpg');
	position: absolute;
	top: 40%;
	left: 25%;
	margin-top: -100px;
	margin-left: -100px;
	padding: 25px;
	border-radius: 25px;
	border: 1px solid black;
}
</style>