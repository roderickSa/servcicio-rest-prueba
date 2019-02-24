package com.amir.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.dao.ClienteDao;
import com.amir.entidad.Cliente;
import com.amir.repository.ClienteRepository;

@Service
public class ClienteDaoImpl implements ClienteDao{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public List<Cliente> listaClientes() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente cliente(Long id) {
		Optional<Cliente> optional= clienteRepo.findById(id);
		if(optional.isPresent()) {
		return optional.get();
		}
		return null;
	}

	@Override
	public boolean insertarCliente(Cliente cliente) {
		if(cliente!=null) {
			if(cliente.getId()!=null) {
				clienteRepo.save(cliente);
				System.out.println("Actualizado");
			}else {
				clienteRepo.save(cliente);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarCliente(Long id) {
		
		Cliente cliente=cliente(id);
		if(cliente!=null) {
			clienteRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Cliente clientePorEmailClave(String email, String clave) {
		return clienteRepo.findByEmailAndClave(email, clave);
	}

}
