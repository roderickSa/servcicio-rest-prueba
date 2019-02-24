package com.amir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amir.entidad.Categoria;
import com.amir.entidad.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

	List<Producto> findByCategoria(Categoria categoria);
}
