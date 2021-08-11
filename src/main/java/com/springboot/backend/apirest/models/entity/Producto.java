package com.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	@Column(length = 20, nullable = false, unique = true)
	private String codigo;
	
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 60, message = "el tamaño tiene que estar entre 4 y 60")
	@Column(length = 90, nullable = false)
	private String nombre;
	
	@Size(max=150)
	@Column(length = 150, nullable = true)
	private String descripcion;
	
	private Double precio;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();	
	}

	
}
