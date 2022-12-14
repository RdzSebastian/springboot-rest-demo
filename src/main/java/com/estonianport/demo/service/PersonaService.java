package com.estonianport.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.estonianport.demo.commons.genericService.GenericServiceImpl;
import com.estonianport.demo.dao.PersonaDao;
import com.estonianport.demo.model.Persona;

@Service
public class PersonaService extends GenericServiceImpl<Persona, Long> {
	
	@Autowired
	private PersonaDao personaDao;

	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaDao;
	}

}
