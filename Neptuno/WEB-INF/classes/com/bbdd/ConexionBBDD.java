package com.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.Productos;

/**
 * Clase que centraliza los m�todos de acceso a BBDD
 * 
 * @author JAGD
 * @since 27/05/2021
 */

public class ConexionBBDD {

	Connection conexion; 
	int port = 3306;
	String host= "localhost";
	String db  = "neptuno";
	String user="root";
	String password="0123456789";

	String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public void conectar() throws SQLException {
		conexion =  DriverManager.getConnection(url, user, password);
	}	
	 

	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
	}

	public ResultSet ejecutarSentencia(String sentencia) {
		ResultSet rsResultado = null;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			rsResultado = prepStatement.executeQuery();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return rsResultado;
	}
	public ResultSet ejecutarConsulta(String sentencia) {
		ResultSet rsResultado = null;
		try {
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
			rsResultado = prepStatement.executeQuery();
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		return rsResultado;
	}
	public int insertarProductos(Productos productos) {
		int iRes=0;
		String sInsert="inset into productos (Id_Productos,NombreProducto,NombreCompania,NombreCategoria,Cantidad_Unidad,Precio_Unidad,Unidades_Existencia,Unidades_Pedidas,Nivel,Suspendido) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			System.out.println("Ejecutando: " + sInsert);
			System.out.println("Datos " + productos);
			PreparedStatement ps = conexion.prepareStatement(sInsert);
			ps.setString(1, productos.getId_Productos());
			ps.setString(2, productos.getNombreProducto());
			ps.setString(3, productos.getNombreCompania());;
			ps.setString(4, productos.getNombreCategoria());
			ps.setString(5, productos.getCantidad_Unidad());
			ps.setString(6, productos.getPrecio_Unidad());
			ps.setString(7, productos.getUnidades_Existencia());
			ps.setString(8, productos.getUnidades_Pedidas());
			ps.setString(9, productos.getNivel());
			ps.setString(10, productos.getSuspendido());
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return iRes;
	}
}
