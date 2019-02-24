package com.amir.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.dao.PedidoDao;
import com.amir.dao.Pedido_DetalleDao;
import com.amir.dao.ProductoDao;
import com.amir.entidad.Pedido;
import com.amir.entidad.Pedido_Detalle;
import com.amir.entidad.Producto;
import com.amir.repository.Pedido_DetalleRepository;

@Service
public class Pedido_DetalleDaoImpl implements Pedido_DetalleDao{
	
	@Autowired
	private Pedido_DetalleRepository pedeRepo;
	
	@Autowired
	private PedidoDao pedidoDao;
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<Pedido_Detalle> listaPedido_Detalle() {
		return pedeRepo.findAll();
	}

	@Override
	public Pedido_Detalle pedido_detalle(Long id) {
		Optional<Pedido_Detalle> optional=pedeRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean insertarPedido_Detalle(Pedido_Detalle pedido_detalle) {
		Pedido pedido=pedidoDao.pedido(pedido_detalle.getPedido().getId());
		Producto producto=productoDao.producto(pedido_detalle.getProducto().getId());
		if(producto!=null && pedido!=null) {
			pedido_detalle.setPedido(pedido);
			pedido_detalle.setProducto(producto);
			pedeRepo.save(pedido_detalle);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarPedido_Detalle(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
