package com.amir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.dao.ClienteDao;
import com.amir.entidad.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	@GetMapping("/listar")
	public List<Cliente> listarClientes(){		
		return clienteDao.listaClientes();
	}
	@GetMapping("/buscar/id/{id}")
	public Cliente buscarPorId(@PathVariable("id")Long id) {
		return clienteDao.cliente(id);
	}
	@GetMapping("/buscar/cuenta/{email}/{clave}")
	public Cliente buscarPorCorreoContraseña(@PathVariable("email")String email,@PathVariable("clave")String clave) {
		return clienteDao.clientePorEmailClave(email, clave);
	}
	@PostMapping("/insertar")
	public boolean insertarCliente(@RequestBody Cliente cliente) {
		return clienteDao.insertarCliente(cliente);
	}
	@PostMapping("/actualizar")
	public boolean actualizarCliente(@RequestBody Cliente cliente) {
		return clienteDao.insertarCliente(cliente);
	}
}
