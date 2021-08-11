package com.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springboot.backend.apirest.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="categories")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = Constants.NOT_EMPTY)
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	@Column(name = "code", length = 20, nullable = false, unique = true)
    public String codeCategory;
	
	@NotEmpty(message = Constants.NOT_EMPTY)
	@Size(min = 4, max = 100)
	@Column(length = 100, nullable = false)
	@Pattern(regexp = "^[A-Za-z0-9\\\\s_-]+$", message="El nombre debe ser alphanumerico y solo permite, guion bajo y medio ")
    public String name;
	public String groupCategory;
	
	@Column(length = 155, nullable = true)
	public String image;
	
	@NotEmpty(message = Constants.NOT_EMPTY)
	@Size(max = 2)
	@Column(length = 2, nullable = true)
	public String enable;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
    public Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, name = "updated_at", 
	        updatable = false,
	        columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@PrePersist
	public void prePersist() {
		createdAt = new Date();	
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
}
