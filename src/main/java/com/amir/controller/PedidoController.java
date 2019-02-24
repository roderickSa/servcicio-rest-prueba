package com.amir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.daoImpl.PedidoDaoImpl;
import com.amir.entidad.Pedido;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoDaoImpl pedidoDao;
	
	@GetMapping("/listar")
	public List<Pedido> listarPedidos(){		
		return pedidoDao.listaPedidos();
	}
	@GetMapping("/buscar/id/{id}")
	public Pedido buscarPorId(@PathVariable("id")Long id) {
		return pedidoDao.pedido(id);
	}
	@GetMapping("/buscar/cliente/{idCliente}")
	public Pedido buscarPorCliente(@PathVariable("idCliente")Long idCliente) {
		return pedidoDao.pedidoPorIdCliente(idCliente);
	}
	@GetMapping("/buscar/estado/{estado}")
	public Pedido buscarPorEstado(@PathVariable("estado")String estado) {
		return pedidoDao.pedidoEstado(estado);
	}
	@PostMapping("/editar/estado/{id}")
	public boolean editarEstado(@PathVariable("id")Long id) {
		return pedidoDao.editarEstado(id);
	}
	@PostMapping("/insertar/{idCliente}")
	public boolean insertarPedido(@RequestBody Pedido pedido,@PathVariable("idCliente") Long idCliente) {
		return pedidoDao.insertarPedido(pedido, idCliente);
	}
	@PostMapping("/insertar")
	public boolean insertarPedido2(@RequestBody Pedido pedido) {
		return pedidoDao.insertarPedido2(pedido);
	}
}
