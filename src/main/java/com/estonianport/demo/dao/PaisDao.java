package com.estonianport.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.estonianport.demo.model.Pais;

public interface PaisDao extends CrudRepository<Pais, Long> {

}
