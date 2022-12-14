package com.model;

public class Productos {
	private String Id_Productos;
	private String NombreProducto;
	private String NombreCompania;
	private String NombreCategoria;
	private String Cantidad_Unidad;
	private String Precio_Unidad;
	private String Unidades_Existencia;
	private String Unidades_Pedidas;
	private String Nivel;
	private String Suspendido;
	public Productos(String id_Productos, String nombreProducto, String NombreCompania, String NombreCategoria,
			String cantidad_Unidad,String precio_Unidad, String unidades_Existencia, String unidades_Pedidas, String nivel,
			String suspendido) {
		super();
		this.Id_Productos = id_Productos;
		this.NombreProducto = nombreProducto;
		this.NombreCompania = NombreCompania;
		this.NombreCategoria = NombreCategoria;
		this.Cantidad_Unidad = cantidad_Unidad;
		this.Precio_Unidad = precio_Unidad;
		this.Unidades_Existencia = unidades_Existencia;
		this.Unidades_Pedidas = unidades_Pedidas;
		this.Nivel = nivel;
		this.Suspendido = suspendido;
	}
	public String getId_Productos() {
		return Id_Productos;
	}
	public void setId_Productos(String id_Productos) {
		this.Id_Productos = id_Productos;
	}
	public String getNombreProducto() {
		return NombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.NombreProducto = nombreProducto;
	}
	public String getNombreCompania() {
		return NombreCompania;
	}
	public void setNombreCompania(String NombreCompania) {
		this.NombreCompania = NombreCompania;
	}
	public String getNombreCategoria() {
		return NombreCategoria;
	}
	public void setNombreCategoria(String NombreCategoria) {
		this.NombreCategoria = NombreCategoria;
	}
	public String getCantidad_Unidad() {
		return Cantidad_Unidad;
	}
	public void setCantidad_Unidad(String cantidad_Unidad) {
		this.Cantidad_Unidad = cantidad_Unidad;
	}
	public String getPrecio_Unidad() {
		return Precio_Unidad;
	}
	public void setPrecio_Unidad(String precio_Unidad) {
		Precio_Unidad = precio_Unidad;
	}
	public String getUnidades_Existencia() {
		return Unidades_Existencia;
	}
	public void setUnidades_Existencia(String unidades_Existencia) {
		this.Unidades_Existencia = unidades_Existencia;
	}
	public String getUnidades_Pedidas() {
		return Unidades_Pedidas;
	}
	public void setUnidades_Pedidas(String unidades_Pedidas) {
		this.Unidades_Pedidas = unidades_Pedidas;
	}
	public String getNivel() {
		return Nivel;
	}
	public void setNivel(String nivel) {
		this.Nivel = nivel;
	}
	public String getSuspendido() {
		return Suspendido;
	}
	public void setSuspendido(String suspendido) {
		this.Suspendido = suspendido;
	}
}
