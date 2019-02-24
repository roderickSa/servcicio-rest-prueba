package com.amir.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.dao.PedidoDao;
import com.amir.entidad.Cliente;
import com.amir.entidad.Pedido;
import com.amir.repository.PedidoRepository;

@Service
public class PedidoDaoImpl implements PedidoDao{
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private ClienteDaoImpl clienteDao;

	@Override
	public List<Pedido> listaPedidos() {
		return pedidoRepo.findAll();
	}

	@Override
	public Pedido pedido(Long id) {
		Optional<Pedido> optional=pedidoRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean insertarPedido(Pedido pedido,Long id) {
		Cliente cliente=clienteDao.cliente(id);
		if(cliente!=null) {
			pedido.setCliente(cliente);
			pedidoRepo.save(pedido);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarPedido(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido pedidoPorIdCliente(Long id) {
		Cliente cliente=clienteDao.cliente(id);
		if(cliente!=null) {
			return pedidoRepo.findByCliente(cliente);
		}
		return null;
	}

	@Override
	public boolean insertarPedido2(Pedido pedido) {
		
		Cliente cliente=clienteDao.cliente(pedido.getCliente().getId());
		if(cliente!=null) {
			pedido.setCliente(cliente);
			pedidoRepo.save(pedido);
			return true;
		}
		return false;
	}

	@Override
	public Pedido pedidoEstado(String estado) {
		return pedidoRepo.findByEstado(estado);
	}

	@Override
	public boolean editarEstado(Long id) {
		Optional<Pedido> optional=pedidoRepo.findById(id);
		if(optional.isPresent()) {
			Pedido pedido=optional.get();
			pedido.setEstado("INABILITADO");
			pedidoRepo.save(pedido);
			return true;
		}
		return false;
	}

}
