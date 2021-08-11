package com.springboot.backend.apirest.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.backend.apirest.models.dao.ICategoryDao;
import com.springboot.backend.apirest.models.entity.Category;
import com.springboot.backend.apirest.models.services.CategoryServiceImp;
import com.springboot.backend.apirest.utils.CustomResponse;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = CategoryController.class)
public class CategoryControllerTest {
	
	protected MockMvc mockMvc;
	
	@MockBean
	private CategoryServiceImp service;
	
	@Mock
	private ICategoryDao dao;
	
	@InjectMocks
	CategoryController categoryController;
	
	@Autowired
    ObjectMapper mapper;
	    
	 @Test
	    public void testAdd() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        when(service.saveOrUpdate((Category) any(Category.class), null)).thenReturn(null);
	         
	        Category employee = new Category();
	        CustomResponse<Category> responseEntity = categoryController.create(employee, null);
	         
	        assertThat(responseEntity.getHttpStatus()).isEqualTo(201);
	    }
	
}
