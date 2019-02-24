package com.amir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amir.entidad.Cliente;
import com.amir.entidad.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	Pedido findByCliente(Cliente cliente);
	Pedido findByEstado(String estado);
}
