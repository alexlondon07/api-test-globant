package com.springboot.backend.apirest.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.models.entity.Category;
import com.springboot.backend.apirest.models.services.CRUDService;
import com.springboot.backend.apirest.utils.Constants;
import com.springboot.backend.apirest.utils.CustomResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = { Constants.APLICATION_FRONT, "*" })
@RestController	
@RequestMapping(Constants.RRQUEST_MAPPING)
@Api(value = "CategoryControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
	
	@Autowired
	CRUDService<Category> service;

	@ApiOperation("Gets the categories")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Category.class) })
	@GetMapping("/categories")
	public List<Category> index() {
		return service.listAll();
	}
	
	@ApiOperation("Gets the categories and pagination")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Category.class) })
	@GetMapping("/categories/page/{page}/{size}")
	public Page<Category> index(@PathVariable Integer page, @PathVariable Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return service.findAllPage(pageable);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@ApiOperation("Gets the categorY with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Category.class) })
	@GetMapping("/categories/{id}")
	public @ResponseBody CustomResponse<Category> show(@PathVariable("id") @NotBlank @Min(1) @Size(max = 15) Long id) {
		return service.getById(id);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@ApiOperation("Delete category with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Category.class) })
	@DeleteMapping("/categories/{id:[0-9]+}")
	public CustomResponse<Category> delete(@PathVariable @Min(1) Long id) {
		return service.delete(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@ApiOperation("Create and update category")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Category.class) })
	@PostMapping("/categories")
	public CustomResponse<Category> create(@Valid @RequestBody Category data, BindingResult result) {
		return service.saveOrUpdate(data, result);
	}
}
