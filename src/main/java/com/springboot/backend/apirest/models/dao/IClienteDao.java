package com.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.apirest.models.entity.Client;
import com.springboot.backend.apirest.models.entity.Region;

public interface IClienteDao extends JpaRepository<Client, Long> {

	@Query("from Region")
	public List<Region> findAllRegiones();
}
	