package com.amir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.dao.CategoriaDao;
import com.amir.entidad.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaDao categoriaDao;
	
	@GetMapping("/listar")
	public List<Categoria> listaCategorias(){
		return categoriaDao.listaCategorias();
	}
	@GetMapping("/buscar/id/{id}")
	public Categoria categoria(@PathVariable("id")Long id) {
		return categoriaDao.categoria(id);
	}
}
