package com.amir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amir.entidad.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
