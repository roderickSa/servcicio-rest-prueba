package com.amir.dao;

import java.util.List;

import com.amir.entidad.Categoria;

public interface CategoriaDao {

	List<Categoria> listaCategorias();
	Categoria categoria(Long id);
	boolean insertarCategoria(Categoria categoria);
	boolean eliminarCategoria(Long id);
}
