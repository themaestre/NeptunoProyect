<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<audio autoplay loop>
   <source src="Shop.mp3">
</audio>
<h1 class="mb-0 text-center gradiente">
Portal de Pedidos
</h1>
<p class="gradiente mb-0  text-center">
Escoje los productos que quieras comprar.
</p>
  <form action="fin.html">
	<table class="table table-bordered border-primary gradiente">
		<tr>
			<th>Selección</th>
			<th>Nombre de producto</th>
			<th>Proveedor</th>
			<th>Categoría</th>
			<th>Cantidad por unidad</th>
			<th>Precio por unidad</th>
			<th>Unidades en existencia</th>
		</tr>
		<%
		LinkedList<Productos> lista = Controller.getProductos();
		for (int i = 0; i < lista.size(); i++) {
			out.println("<tr>");
			out.println("<td><input type=\"checkbox\"></td>");
			out.println("<td>" + lista.get(i).getNombreProducto() + "</td>");
			out.println("<td>" + lista.get(i).getNombreCompania() + "</td>");
			out.println("<td>" + lista.get(i).getNombreCategoria() + "</td>");
			out.println("<td>" + lista.get(i).getCantidad_Unidad() + "</td>");
			out.println("<td>" + lista.get(i).getPrecio_Unidad() + "</td>");
			out.println("<td>" + lista.get(i).getUnidades_Existencia() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Pedir</button>
  </form>
</body>
</html>