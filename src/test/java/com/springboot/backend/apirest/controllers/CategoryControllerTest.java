package com.springboot.backend.apirest.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.backend.apirest.models.dao.ICategoryDao;
import com.springboot.backend.apirest.models.entity.Category;
import com.springboot.backend.apirest.models.services.CategoryServiceImp;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = CategoryController.class)
public class CategoryControllerTest {
	
	protected MockMvc mockMvc;
	
	@InjectMocks
	private CategoryServiceImp service;
	
	@Mock
	private ICategoryDao dao;
	
	@InjectMocks
	CategoryController categoryController;
	
	@Autowired
    ObjectMapper mapper;
	    
	List<Category> list;
	Category category0;
	Category category1;
	
	@org.junit.Before
    public void setup() {  	
    	category0 = Category.builder().codeCategory("10381").name("categoria-tes").groupCategory("tenis").enable("si").build();
    	category1 = Category.builder().codeCategory("103812").name("categoria_tes-2").groupCategory("tenis 2").enable("si").build();	  
    	list = Arrays.asList(category0, category1);	    	
    }
	
	@Test
	public void getProductsbadRequest() {
		when(categoryController.index()).thenReturn(list);
		List<Category> response = service.listAll();

		assertEquals(response.size(),2);
	}
	 

	
}
