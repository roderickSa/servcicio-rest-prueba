package com.amir.dao;

import java.util.List;

import com.amir.entidad.Pedido_Detalle;

public interface Pedido_DetalleDao {

	List<Pedido_Detalle> listaPedido_Detalle();
	Pedido_Detalle pedido_detalle(Long id);
	boolean insertarPedido_Detalle(Pedido_Detalle pedido_detalle);
	boolean eliminarPedido_Detalle(Long id);
}
