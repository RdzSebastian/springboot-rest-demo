package com.estonianport.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.estonianport.demo.model.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}
