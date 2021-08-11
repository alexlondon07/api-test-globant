package com.springboot.backend.apirest.models.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.springboot.backend.apirest.exceptions.CodeNumberViolationException;
import com.springboot.backend.apirest.exceptions.ResourceNotFoundException;
import com.springboot.backend.apirest.models.dao.ICategoryDao;
import com.springboot.backend.apirest.models.entity.Category;
import com.springboot.backend.apirest.utils.Constants;
import com.springboot.backend.apirest.utils.CustomResponse;
	
@Service
public class CategoryServiceImp implements CRUDService<Category> {
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImp.class);

	@Autowired ICategoryDao dao;
	
	@Override
	public List<Category> listAll() {
		return (List<Category>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CustomResponse<Category> getById(Long id) {
		Category category = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Category with ID :"+id+" Not Found!"));
		return new CustomResponse<>(Boolean.TRUE, "Datos", 200, category);
	}
	
	@Transactional
	public CustomResponse<Category> saveOrUpdate(Category domainObject, BindingResult result) {
		if (result.hasErrors()) {
			String errors = CustomResponse.getFielErrorResponse(result);
			return new CustomResponse<>(Boolean.FALSE, errors.toString(), HttpStatus.CONFLICT);
		}
		
		String code = domainObject.getCodeCategory();
		if(dao.findByCodeCategory(domainObject.getCodeCategory()).isPresent()) {
			throw  new CodeNumberViolationException(code +" was previously created!");
		}
		Category category = dao.save(domainObject);
		return new CustomResponse<>(Boolean.TRUE, "Category created with success", HttpStatus.CREATED, category);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Category> findAllPage(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public CustomResponse<Category> delete(Long id) {
		dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Category with ID :"+id+" Not Found!"));
		dao.deleteById(id);
		return new CustomResponse<>(Boolean.TRUE, Constants.DELETE_MESSAGE, HttpStatus.ACCEPTED);
	}
}
