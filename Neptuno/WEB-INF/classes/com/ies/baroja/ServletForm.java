package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.Productos;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("Inicio doPost()");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			if (request.getParameter("email") != null) {
				loginUsuario(request, response);
			}else if (request.getParameter("NombreProducto") != null) {
				altaProductos(request, response);
			}else if (request.getParameter("buscaNombre") != null) {
				buscaProducto(request, response);
			}else {
				System.out.println("Opcion no valida");
				mostrarError(response);
			}

		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response);
		}
	}

	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Inicio login");
		//Podemos guardar informacion en la sesion del usuario
		HttpSession sesion = request.getSession();
		String sEmail = request.getParameter("email");
		System.out.println("Email="+sEmail);
		String sPwd = request.getParameter("pwd");
		System.out.println("Password="+sPwd);
		// deberiamos buscar el usuario en la base de datos, pero 
		//ponemos un ejemplo en el mismo codigo
		if (sEmail.equals("micorreo@gmail.com") && sPwd.equals("Passw0rd") || sEmail.equals("erick_michael2001@hotmail.com") && sPwd.equals("Passw0rd")) {
			System.out.println("Acceso garantizado");
			// si coincide email y password y ademas no hay sesion iniciada
			sesion.setAttribute("email", sEmail);
			// redirijo a pagina con informacon de login exitoso
			response.sendRedirect("Proyecto T5 HTML\\loginExito.jsp");//PortalEmpleados.html//loginExito.jsp
		} else {
			// logica para login invalido
			System.out.println("Error por else");
			mostrarError(response);
		}

	}

	private static void altaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/** 1- recogida de datos */
		Productos productos = new Productos(request.getParameter("Id_Productos"), request.getParameter("NombreProducto"),
				request.getParameter("NombreCompania"), request.getParameter("NombreCategoria"), request.getParameter("Cantidad_Unidad"),
				request.getParameter("Precio_Unidad"), request.getParameter("Unidades_Existencia"), request.getParameter("Unidades_Pedidas"),
				request.getParameter("Nivel"), request.getParameter("Suspendido"));
		System.out.println("Recogida de datos de la pagina");
		/** 2- Insertar producto en la base de datos */
		boolean bRes = Controller.insertarProductos(productos);
		System.out.println("Productos insertados");
		/** 3- Mostrar resultado por pantalla */
		System.out.println("Resultado mostrado");
		if (bRes) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML>\n" + "<HEAD>" + "  <meta charset=\"utf-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
					+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
					+ "  <link rel=\"stylesheet\" href=\"Proyecto T5 HTML\\modificaciones.css\">\r\n"
					+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
					+ "<h2 class=\"text-success\">Producto insertado correctamente<h2>\n"
					+ "<ul class=\"list-group\"> \n" 
					+ "  <LI class=\"list-group-item\">Id: " + productos.getId_Productos() + "</li>\n" 
					+ "  <LI class=\"list-group-item\">Nombre: " + productos.getNombreProducto() + "</li>\n" 
					+ "  <LI class=\"list-group-item\">Proveedor: " + productos.getNombreCompania() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Categoria: " + productos.getNombreCategoria() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Cantidad por unidad: " + productos.getCantidad_Unidad() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Precio por unidad: " + productos.getPrecio_Unidad() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Unidades en existencia: " + productos.getUnidades_Existencia() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Unidades pedidas: " + productos.getUnidades_Pedidas() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Nivel de nuevo pedido: " + productos.getNivel() + "</li>\n"
					+ "  <LI class=\"list-group-item\">Suspendido: " + productos.getSuspendido() + "</li>\n"
					+ "</UL>\n" +"<a href=\"Proyecto T5 HTML\\PortalEmpleados.html\" class=\"link-info\">Volver</a>"+ "</div></BODY></HTML>");
			out.close();

		} else {
			// Mostramos que se ha producido un error
			mostrarError(response);

		}
	}
	private static void buscaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1 Recogida de datos de la pagina
		String sNombreProductos=request.getParameter("buscaNombre");
		System.out.println("Recogida de datos de la pagina");
		//2 Buscar producto en la base de datos
		Productos productos=Controller.getProducto(sNombreProductos);
		System.out.println("Buscar producto en la base de datos");
		if(productos!=null) {
			//3 Producto encontrado lo incluimos en la sesion
			HttpSession sesion=request.getSession();
			System.out.println("Producto encontrado lo incluimos en la sesion");
			//si coincide email y password y ademas no hay sesion iniciada
			sesion.setAttribute("productos", productos);
			System.out.println("Coincidencia en la sesion");
			//redirijo a pagina con informacion de login exito
			response.sendRedirect("Proyecto T5 HTML\\listaProductos.jsp");
			System.out.println("Redirijo a pagina");
		}else {
			//producto no encontrado
			mostrarError(response);
			System.out.println("Error o producto no encontrado");
		}
	}
	private static void mostrarError(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "  <link rel=\"stylesheet\" href=\"Proyecto T5 HTML\\modificaciones.css\">\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n"
				+ "<img src=\"Proyecto T5 HTML\\error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}

}