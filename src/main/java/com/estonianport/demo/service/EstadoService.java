package com.estonianport.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.estonianport.demo.commons.genericService.GenericServiceImpl;
import com.estonianport.demo.dao.EstadoDao;
import com.estonianport.demo.model.Estado;
import com.estonianport.demo.model.Pais;

@Service
public class EstadoService extends GenericServiceImpl<Estado, Long> {
	
	@Autowired
	private EstadoDao estadoDao;

	@Override
	public CrudRepository<Estado, Long> getDao() {
		return estadoDao;
	}
	
	public List<Estado> getEstadosByPais(Pais pais){
		return estadoDao.getEstadosByPais(pais);
	}

}
