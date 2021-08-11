package com.springboot.backend.apirest.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.backend.apirest.models.entity.Client;
import com.springboot.backend.apirest.models.entity.Region;
import com.springboot.backend.apirest.models.services.IClienteService;
import com.springboot.backend.apirest.utils.Constants;
import com.springboot.backend.apirest.utils.CustomResponse;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;

@CrossOrigin(origins = { Constants.APLICATION_FRONT, "*" })
@RestController
@RequestMapping(Constants.RRQUEST_MAPPING)
@Api(value = "ClienteRestController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteRestController {

	private final Logger log = (Logger) LoggerFactory.getLogger(ClienteRestController.class);
	
	@Autowired
	IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Client> index() {
		return clienteService.findAll();
	}

	@GetMapping("/clientes/page/{page}/{size}")
	public Page<Client> index(@PathVariable Integer page, @PathVariable Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return clienteService.findAllPage(pageable);
	}

    /*/**----------------------------------------------------------------------------------------------------
    * *                    							SHOW
    *-------------------------------------------------------------------------------------------------------**/
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/clientes/{id}")
	public @ResponseBody CustomResponse<Client> show(@PathVariable Long id) {

		Client cliente = null;
		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			return new CustomResponse<>(Boolean.FALSE, Constants.ERROR_DATA_ACCESS_EXCEPTION, 500);
		}

		if (cliente == null) {
			return new CustomResponse<>(Boolean.FALSE, "Cliente con el id " + id + " no fue encontrado ", 404);
		}

		return new CustomResponse<>(Boolean.TRUE, "Cliente", 200, cliente);

	}

    /*/**----------------------------------------------------------------------------------------------------
    * *                    							SAVE
    *-------------------------------------------------------------------------------------------------------**/
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/clientes")
	public @ResponseBody CustomResponse<Client> save(@Valid @RequestBody Client data, BindingResult result) {

		// Validaciones
		if (result.hasErrors()) {
			String errors = CustomResponse.getFielErrorResponse(result);
			return new CustomResponse<>(Boolean.FALSE, errors.toString(), 500);
		}

		Client cliente = null;
		try {
			cliente = clienteService.save(data);
		} catch (DataAccessException e) {
			return new CustomResponse<>(Boolean.FALSE, Constants.ERROR_DATA_ACCESS_EXCEPTION_INSERT, 500);
		}
		return new CustomResponse<>(Boolean.TRUE, "Cliente guardado correctamente", 201, cliente);
	}

    /*/**----------------------------------------------------------------------------------------------------
    * *                    							UPDATE
    *-------------------------------------------------------------------------------------------------------**/
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/clientes/{id}")
	public @ResponseBody CustomResponse<Client> update(@RequestBody Client cliente, BindingResult result,
			@PathVariable Long id) {

		// Validaciones
		if (result.hasErrors()) {
			String errors = CustomResponse.getFielErrorResponse(result);
			return new CustomResponse<>(Boolean.FALSE, errors.toString(), 500);
		}

		Client clienteActual = clienteService.findById(id);
		Client clienteActualizado = null;

		if (clienteActual == null) {
			return new CustomResponse<>(Boolean.FALSE, "Cliente con el id " + id + " no fue encontrado ", 404);
		}

		try {
			clienteActual.setTipoDocumento(cliente.getTipoDocumento());
			clienteActual.setDocumento(cliente.getDocumento());
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setApellido(cliente.getApellido());
			clienteActual.setFecha_nacimiento(cliente.getFecha_nacimiento());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setTelefono(cliente.getTelefono());
			clienteActual.setDireccion(cliente.getDireccion());
			clienteActual.setRegion(cliente.getRegion());
			clienteActualizado = clienteService.save(clienteActual);
		} catch (DataAccessException e) {
			return new CustomResponse<>(Boolean.FALSE, Constants.ERROR_DATA_ACCESS_EXCEPTION_UPDATE, 500);
		}

		return new CustomResponse<>(Boolean.TRUE, "Cliente actualizado correctamente", 201, clienteActualizado);
	}

    /*/**----------------------------------------------------------------------------------------------------
    * *                    							DELETE
    *-------------------------------------------------------------------------------------------------------**/
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/clientes/{id}")
	public CustomResponse<?> delete(@PathVariable Long id) {
		try {

			Client cliente = clienteService.findById(id);
			if (cliente == null) {
				return new CustomResponse<>(Boolean.FALSE, "Cliente a eliminar con el id " + id + " no fue encontrado ",
						404);
			}

			String fileNameOld = cliente.getImg();
			if (fileNameOld != null && fileNameOld.length() > 0) {
				Path fileRouteOld = Paths.get("uploads").resolve(fileNameOld).toAbsolutePath();
				File fileImgOld = fileRouteOld.toFile();
				if (fileImgOld.exists() && fileImgOld.canRead()) {
					fileImgOld.delete();
				}
			}

			clienteService.delete(id);
		} catch (DataAccessException e) {
			return new CustomResponse<>(Boolean.FALSE, Constants.ERROR_DATA_ACCESS_EXCEPTION_DELETE, 500);
		}
		return new CustomResponse<>(Boolean.TRUE, "Cliente eliminado correctamente", 201, id);
	}

    /*/**----------------------------------------------------------------------------------------------------
    * *                    							UPLOAD
    *-------------------------------------------------------------------------------------------------------**/
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/clientes/upload")
	public CustomResponse<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {

		String fileName = null;
		Path fileRoute = null;

		Client cliente = clienteService.findById(id);
		if (cliente == null) {
			return new CustomResponse<>(Boolean.FALSE, "Cliente con el id " + id + " no fue encontrado ", 404);
		}

		try {
			if (!file.isEmpty()) {
				fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
				fileRoute = Paths.get("uploads").resolve(fileName).toAbsolutePath();
				Files.copy(file.getInputStream(), fileRoute);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new CustomResponse<>(Boolean.FALSE,
					"Error al subir la imagen " + e.getCause().getMessage().toString(), 500);
		}

		String fileNameOld = cliente.getImg();
		if (fileNameOld != null && fileNameOld.length() > 0) {
			Path fileRouteOld = Paths.get("uploads").resolve(fileNameOld).toAbsolutePath();
			File fileImgOld = fileRouteOld.toFile();
			if (fileImgOld.exists() && fileImgOld.canRead()) {
				fileImgOld.delete();
			}
		}

		cliente.setImg(fileName);
		clienteService.save(cliente);
		return new CustomResponse<>(Boolean.TRUE, "Imagen subida correctamente", 201, cliente);
	}

    /*/**----------------------------------------------------------------------------------------------------
    * *                    							SHOW IMG
    *-------------------------------------------------------------------------------------------------------**/
	@GetMapping("/uploads/img/{fileName:.+}")
	public ResponseEntity<Resource> showImg(@PathVariable String fileName){
		
		Path fileRoute = Paths.get("uploads").resolve(fileName).toAbsolutePath();

		log.info(fileRoute.toString());
		
		Resource resource = null;
		
		try {
			resource = new UrlResource(fileRoute.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!resource.exists() && !resource.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen: " + fileName);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ( resource).getFilename() + "\"");
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
    /*/**----------------------------------------------------------------------------------------------------
    * *                    							LIST REGION
    *-------------------------------------------------------------------------------------------------------**/
	@GetMapping("/regiones")
	public List<Region> listRegion() {
		return clienteService.findAllRegiones();
	}

}
