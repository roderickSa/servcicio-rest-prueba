package com.amir.dao;

import java.util.List;

import com.amir.entidad.Cliente;

public interface ClienteDao {

	List<Cliente> listaClientes();
	Cliente cliente(Long id);
	Cliente clientePorEmailClave(String email,String clave);
	boolean insertarCliente(Cliente cliente);
	boolean eliminarCliente(Long id);
}
