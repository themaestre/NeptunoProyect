<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.model.Productos"%>
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

		<h1 class="text-primary">Producto Encontrado</h1>
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
		HttpSession misesion = request.getSession();
		Productos productos = (Productos) misesion.getAttribute("productos");
		if (productos!=null){
			out.println("<tr>");
			out.println("<td>" + productos.getId_Productos() + "</td>");
			out.println("<td>" + productos.getNombreProducto() + "</td>");
			out.println("<td>" + productos.getNombreCompania() + "</td>");
			out.println("<td>" + productos.getNombreCategoria() + "</td>");
			out.println("<td>" + productos.getCantidad_Unidad() + "</td>");
			out.println("<td>" + productos.getPrecio_Unidad() + "</td>");
			out.println("<td>" + productos.getUnidades_Existencia() + "</td>");
			out.println("<td>" + productos.getUnidades_Pedidas() + "</td>");
			out.println("<td>" + productos.getNivel() + "</td>");
			out.println("<td>" + productos.getSuspendido() + "</td>");
			out.println("</tr>");
		}
		%>
		</table>
</body>
</html>