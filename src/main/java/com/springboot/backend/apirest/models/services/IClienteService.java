package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.backend.apirest.models.entity.Client;
import com.springboot.backend.apirest.models.entity.Factura;
import com.springboot.backend.apirest.models.entity.Producto;
import com.springboot.backend.apirest.models.entity.Region;

public interface IClienteService {

	public List<Client> findAll();
	
	public Page<Client> findAllPage( Pageable pageable );
	
	public Client findById(Long id);
	
	public Client save(Client cliente);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();
	
	public Factura findFacturaById(Long id);
	
	
	public Factura saveFactura(Factura factura);
	
	public void deleteFacturaById(Long id);
	
	public List<Producto> findProductoByNombre(String term);
}
