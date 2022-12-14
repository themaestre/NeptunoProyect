package com.test;

import java.util.LinkedList;

import com.ies.baroja.Controller;
import com.model.Productos;
public class TestController {

	public static void main(String[] args) {
		System.out.println("Inicio de TestController");
		LinkedList<Productos> listaProductos=Controller.getProductos();
		System.out.println("Total de productos="+listaProductos.size());
		System.out.println("Listado="+listaProductos.toString());
	}

}
