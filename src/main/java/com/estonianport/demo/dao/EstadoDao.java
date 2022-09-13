package com.estonianport.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.estonianport.demo.model.Estado;
import com.estonianport.demo.model.Pais;

public interface EstadoDao extends CrudRepository<Estado, Long> {

	List<Estado> getEstadosByPais(Pais pais);

}
