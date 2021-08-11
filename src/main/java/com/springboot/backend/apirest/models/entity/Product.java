package com.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 60, message = "el tamaño tiene que estar entre 4 y 60")
	@Column(length = 60, nullable = false, unique = true)
    public String codigo;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 60, message = "el tamaño tiene que estar entre 4 y 60")
	@Column(length = 60, nullable = false)
    public String tipo;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 90, message = "el tamaño tiene que estar entre 4 y 90")
	@Column(length = 90, nullable = false)
    public String plu;
	
    // public String proveedor_id;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 90, message = "el tamaño tiene que estar entre 4 y 90")
	@Column(length = 90, nullable = false)
	public String nombre_prod;
	
    // public String categoria_id;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	@Column(length = 20, nullable = true)
    public String presentacion;
	
    public BigDecimal p_venta;
    public BigDecimal p_venta2;
    public BigDecimal p_venta3;
    
    public String rentabilidad1;
    public String rentabilidad2;
    public String rentabilidad3;
    
    public String image;
    public String impuesto;
    public String impo_consumo;
    public String impuesto_incluido;
    public String tipo_impuesto;
    public String costo;
    public String cant_minima;
    public int cant_ini;
    public int cant_actual;
    public int quantity;
    public String descripcion;
    
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 100, message = "el tamaño tiene que estar entre 4 y 100")
	@Column(length = 100, nullable = true)
    public String barcode_symbology;
	
    public BigDecimal precio_gravable_1;
    public BigDecimal precio_gravable_2;
    public BigDecimal precio_gravable_3;
    
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 60, message = "el tamaño tiene que estar entre 4 y 60")
	@Column(length = 60, nullable = true)
    public String type;
	
	@Column(name = "alert_quantity")
    public String alertQuantity;
    
    @NotEmpty(message = "no puede estar vacio")
	@Size(max = 2, message = "el tamaño tiene que estar ser 2 carateres")
	@Column(length = 2, nullable = true)
    public String enable;
    
    
	@NotNull(message = "no puede estar vacio")
	@Temporal(TemporalType.DATE)
	@Column(name = "dtcreate")
    public Date dtCreate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", 
	        updatable = false,
	        columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;
    
}
