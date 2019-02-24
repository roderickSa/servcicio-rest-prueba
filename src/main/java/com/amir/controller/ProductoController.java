package com.amir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.dao.ProductoDao;
import com.amir.entidad.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoDao productoDao;
	
	@GetMapping("/listar")
	public List<Producto> listaProductos(){
		return productoDao.listaProductos();
	}
	@GetMapping("/buscar/id/{id}")
	public Producto producto(@PathVariable("id")Long id) {
		return productoDao.producto(id);
	}
	@GetMapping("/buscar/idCategoria/{id}")
	public List<Producto> productosCategoria(@PathVariable("id")Long id) {
		return productoDao.productoCategoria(id);
	}
}
