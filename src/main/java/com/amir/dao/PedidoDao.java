package com.amir.dao;

import java.util.List;

import com.amir.entidad.Pedido;

public interface PedidoDao {

	List<Pedido> listaPedidos();
	Pedido pedido(Long id);
	Pedido pedidoPorIdCliente(Long id);
	Pedido pedidoEstado(String estado);
	boolean editarEstado(Long id);
	boolean insertarPedido(Pedido pedido,Long id);
	boolean insertarPedido2(Pedido pedido);
	boolean eliminarPedido(Long id);
}
