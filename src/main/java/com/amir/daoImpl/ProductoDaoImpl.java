package com.amir.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.dao.ProductoDao;
import com.amir.entidad.Categoria;
import com.amir.entidad.Cliente;
import com.amir.entidad.Producto;
import com.amir.repository.CategoriaRepository;
import com.amir.repository.ProductoRepository;

@Service
public class ProductoDaoImpl implements ProductoDao{

	@Autowired
	private ProductoRepository productoRepo;	
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public List<Producto> listaProductos() {
		return productoRepo.findAll();
	}

	@Override
	public Producto producto(Long id) {
		Optional<Producto> optional=productoRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean insertarProducto(Producto producto) {
      return false;
	}

	@Override
	public boolean eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> productoCategoria(Long id) {
		Optional<Categoria> optional=categoriaRepo.findById(id);
		if(optional.isPresent()) {
			return productoRepo.findByCategoria(optional.get());
		}
		return null;
	}

}
