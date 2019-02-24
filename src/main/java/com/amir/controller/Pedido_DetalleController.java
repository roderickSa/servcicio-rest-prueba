package com.amir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.daoImpl.Pedido_DetalleDaoImpl;
import com.amir.entidad.Pedido_Detalle;

@RestController
@RequestMapping("/pedido_detalle")
public class Pedido_DetalleController {

	@Autowired
	private Pedido_DetalleDaoImpl pedeDao;
	
	@GetMapping("/listar")
	public List<Pedido_Detalle> listarPedidos_detalles(){		
		return pedeDao.listaPedido_Detalle();
	}
	@GetMapping("/buscar/id/{id}")
	public Pedido_Detalle buscarPorId(@PathVariable("id")Long id) {
		return pedeDao.pedido_detalle(id);
	}
	@PostMapping("/insertar")
	public boolean insertarPedido_Detalle(@RequestBody Pedido_Detalle pedido_detalle) {
		return pedeDao.insertarPedido_Detalle(pedido_detalle);
	}
}
