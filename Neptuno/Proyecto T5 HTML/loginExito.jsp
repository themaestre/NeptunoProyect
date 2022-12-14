<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="modificaciones.css">
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-primary">Bienvenido ${sessionScope.email}</h1>
		<%
		HttpSession misesion = request.getSession();
		//optener variables de la sesión
		//guarda todo como Object, el casteo es obligatorio
		String email = (String) misesion.getAttribute("email");
		//out.println("email=" + email);
		%>
	</div>
	<a href="PortalEmpleados.html" class="btn btn-primary position-absolute top-50 start-50 translate-middle fs-1">Insertar datos</a>
</body>
</html>