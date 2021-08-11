package com.springboot.backend.apirest.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.models.dao.IClienteDao;
import com.springboot.backend.apirest.models.dao.IFacturaDao;
import com.springboot.backend.apirest.models.entity.Client;
import com.springboot.backend.apirest.models.entity.Factura;
import com.springboot.backend.apirest.models.entity.Producto;
import com.springboot.backend.apirest.models.entity.Region;

@Service
public class CientServiceImpl implements IClienteService {

	@Autowired IClienteDao clienteDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return (List<Client>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Client save(Client cliente) {
		return clienteDao.save(cliente);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Client> findAllPage(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return clienteDao.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
	}


	@Override
	public List<Producto> findProductoByNombre(String term) {
		return null;
	}

}
