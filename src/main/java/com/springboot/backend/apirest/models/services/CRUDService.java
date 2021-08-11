package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import com.springboot.backend.apirest.utils.CustomResponse;

public interface CRUDService<T> {
	
	public List<T> listAll();

	public CustomResponse<T> getById(Long id);

	public CustomResponse<T> saveOrUpdate(T domainObject, BindingResult result);

	public CustomResponse<T> delete(Long id);	
   
	public Page<T> findAllPage( Pageable pageable );
}