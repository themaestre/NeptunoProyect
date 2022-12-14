<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Productos"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="modificaciones.css">
</head>
<body>
	<p style="color:white;text-align:center">Lista de Productos Empresas NEPTUNO S.L.</p>
	<form action="../ServletForm" method="POST">
		<div class="input-group">
			<span class="input-group-text">Nombre del producto:</span>
			<input type="text" class="form-control" name="buscaNombre">
			<button type="submit" class="btn btn-primary">Buscar</button>
		</div>
	</form>
	<table class="table table-bordered border-primary gradiente">
		<tr>
			<th>Id_Productos</th>
			<th>Nombre de producto</th>
			<th>Proveedor</th>
			<th>Categoría</th>
		    <th>Cantidad por unidad</th>
		    <th>Precio por unidad</th>
		    <th>Unidades en existencia</th>
		    <th>Unidades pedidas</th>
		    <th>Nivel de nuevo pedido</th>
		    <th>Suspendido</th>
		</tr>
		<%
		LinkedList<Productos> lista = Controller.getProductos();
		for (int i = 0; i < lista.size(); i++) {
			out.println("<tr>");
			out.println("<td>" + lista.get(i).getId_Productos() + "</td>");
			out.println("<td>" + lista.get(i).getNombreProducto() + "</td>");
			out.println("<td>" + lista.get(i).getNombreCompania() + "</td>");
			out.println("<td>" + lista.get(i).getNombreCategoria() + "</td>");
			out.println("<td>" + lista.get(i).getCantidad_Unidad() + "</td>");
			out.println("<td>" + lista.get(i).getPrecio_Unidad() + "</td>");
			out.println("<td>" + lista.get(i).getUnidades_Existencia() + "</td>");
			out.println("<td>" + lista.get(i).getUnidades_Pedidas() + "</td>");
			out.println("<td>" + lista.get(i).getNivel() + "</td>");
			out.println("<td>" + lista.get(i).getSuspendido() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
</body>
</html>