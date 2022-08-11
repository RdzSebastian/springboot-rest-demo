package com.estonianport.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.estonianport.demo.commons.genericService.GenericServiceImpl;
import com.estonianport.demo.dao.PaisDao;
import com.estonianport.demo.model.Pais;

@Service
public class PaisService extends GenericServiceImpl<Pais, Long> {
	
	@Autowired
	private PaisDao paisDao;

	@Override
	public CrudRepository<Pais, Long> getDao() {
		return paisDao;
	}

}
