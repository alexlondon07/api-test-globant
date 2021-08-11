package com.springboot.backend.apirest.models.services;

import com.springboot.backend.apirest.models.entity.User;

public interface IUsuarioService {

	public User findByUsername(String username);
}
