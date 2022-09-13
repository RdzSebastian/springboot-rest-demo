package com.estonianport.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;

	@Column
	private int edad;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

}