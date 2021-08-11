package com.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.backend.apirest.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clientes")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(max=10)
	@Column(length = 10, nullable = false, unique = true)
	private String documento;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;

	@NotEmpty(message = Constants.NOT_EMPTY)
	@Size(min = 4, max = 60, message = "el tamaño tiene que estar entre 4 y 60")
	@Column(length = 60, nullable = false)
	private String nombre;
	
	@NotEmpty(message = Constants.NOT_EMPTY)
	@Size(min = 4, max = 60, message = "el tamaño tiene que estar entre 4 y 60")
	@Size(min=4, max=60)
	@Column(length = 60, nullable = false)
	private String apellido;
	
	@Size(min=4, max=90)
	@Column(length = 90)
	private String direccion;
	
	@Email
	@Size(min=4, max=50)
	@Column(length = 50, unique = true)
	private String email;
	
	@Column(length = 10)
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	
	@NotNull(message = Constants.NOT_EMPTY)
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", 
	        updatable = false,
	        columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;
	
	private String img;
	
	@NotNull(message = "la región no puede ser vacia")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;

	@JsonIgnoreProperties(value={"cliente", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Factura> facturas;
	

	@PrePersist
	public void prePersist() {
		createAt = new Date();	
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
}
