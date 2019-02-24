package com.amir.dao;

import java.util.List;

import com.amir.entidad.Producto;

public interface ProductoDao {

	List<Producto> listaProductos();
	Producto producto(Long id);
	List<Producto> productoCategoria(Long id);
	boolean insertarProducto(Producto producto);
	boolean eliminarProducto(Long id);
}
