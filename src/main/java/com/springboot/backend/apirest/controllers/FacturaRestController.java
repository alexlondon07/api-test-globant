package com.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.models.dao.IFacturaDao;
import com.springboot.backend.apirest.models.entity.Factura;
import com.springboot.backend.apirest.models.services.IClienteService;
import com.springboot.backend.apirest.utils.Constants;

@CrossOrigin(origins = { Constants.APLICATION_FRONT, "*" })
@RestController
@RequestMapping(Constants.RRQUEST_MAPPING)
public class FacturaRestController {

		
	@Autowired IFacturaDao facturasDao;
	@Autowired IClienteService clienteService;
	
	@GetMapping("/facturas")
	public List<Factura> index() {
		return (List<Factura>) facturasDao.findAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Factura show(@PathVariable Long id) {
		return clienteService.findFacturaById(id);	
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteFacturaById(id);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/facturas/filtar/{text}")
	@ResponseStatus(HttpStatus.OK)
	public Factura show(@PathVariable String text) {
		return null;
	}
	
}
