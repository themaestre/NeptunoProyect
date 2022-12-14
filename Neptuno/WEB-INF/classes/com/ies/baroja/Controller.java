package com.ies.baroja;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.model.Productos;
import com.bbdd.ConexionBBDD;
public class Controller {
	private static String sConsultaProductos ="SELECT Id_Productos,NombreProducto,NombreCompania,NombreCategoria,Cantidad_Unidad,Precio_Unidad,Unidades_Existencia,Unidades_Pedidas,Nivel,Suspendido FROM productos;";
	public static LinkedList<Productos> getProductos() {
		//Objeto con la lista de Productos
		LinkedList<Productos> listaProductos = new LinkedList<Productos>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaProductos);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
				//Creamos un objeto producto por cada fila de la tabla (cada productos)
				Productos productos = new
				Productos(rsResultado.getString("Id_Productos"),
				rsResultado.getString("NombreProducto"),
				rsResultado.getString("NombreCompania"),
				rsResultado.getString("NombreCategoria"),
				rsResultado.getString("Cantidad_Unidad"),
				rsResultado.getString("Precio_Unidad"),
				rsResultado.getString("Unidades_Existencia"),
				rsResultado.getString("Unidades_Pedidas"),
				rsResultado.getString("Nivel"),
				rsResultado.getString("Suspendido"));
				//Lo insertamos en la lista
				listaProductos.add(productos);
				}
			} else {
			System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("Numero de productos="+listaProductos.size());
		} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
		}
		finally {
		miConexion.desconectar();
		}
	return listaProductos;
	}
	public static boolean insertarProductos(Productos productos) {
		boolean bRes=true;
		ConexionBBDD miConexion=new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes=miConexion.insertarProductos(productos);
			System.out.println("Resultado= "+iRes);
		}catch (SQLException sqlex){
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
			bRes =false;
		}finally {
			miConexion.desconectar();
		}
		return bRes;
	}
	public static Productos getProducto(String sNombreProducto) {
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		String sBuscaProducto = "SELECT Id_Productos,NombreProducto,NombreCompania,NombreCategoria,Cantidad_Unidad,Precio_Unidad,Unidades_Existencia,Unidades_Pedidas,Nivel,Suspendido FROM productos "
		+ "where NombreProducto = '" + sNombreProducto + "' ;";
		Productos productos = null;
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sBuscaProducto);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					productos = new Productos(rsResultado.getString("Id_Productos"),
							rsResultado.getString("NombreProducto"),
							rsResultado.getString("NombreCompania"),
							rsResultado.getString("NombreCategoria"),
							rsResultado.getString("Cantidad_Unidad"),
							rsResultado.getString("Precio_Unidad"),
							rsResultado.getString("Unidades_Existencia"),
							rsResultado.getString("Unidades_Pedidas"),
							rsResultado.getString("Nivel"),
							rsResultado.getString("Suspendido"));
					System.out.println("producto encontrado=" + productos);
				}
			} else {
			System.out.println("La consulta no devuelve resultados: producto no encontrado");
			}
		} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
		} finally {
		miConexion.desconectar();
		}
	return productos;
	}
}