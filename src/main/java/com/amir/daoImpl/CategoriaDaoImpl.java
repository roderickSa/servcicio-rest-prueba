package com.amir.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.dao.CategoriaDao;
import com.amir.entidad.Categoria;
import com.amir.repository.CategoriaRepository;

@Service
public class CategoriaDaoImpl implements CategoriaDao{

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public List<Categoria> listaCategorias() {
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria categoria(Long id) {
		Optional<Categoria> optional=categoriaRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean insertarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarCategoria(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
