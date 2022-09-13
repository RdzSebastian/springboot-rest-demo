package com.estonianport.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estonianport.demo.model.Estado;
import com.estonianport.demo.model.Pais;
import com.estonianport.demo.service.EstadoService;
import com.estonianport.demo.service.PaisService;

@RestController
@RequestMapping(value = "/rest")
public class EstadoRest {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private PaisService paisService;
	
	@GetMapping(value = "/findEstado/{id}")
	public Estado find(@PathVariable Long id){
		return estadoService.get(id);
	}

	@GetMapping(value = "/allEstado")
	public List<Estado> getAll(){
		return estadoService.getAll();
	}
	
	@GetMapping(value = "/getAllEstadosByPais/{id}")
	public List<Estado> getEstadosByPais(@PathVariable("id") long paisId){
		Pais pais = paisService.get(paisId);
		return estadoService.getEstadosByPais(pais);
	}

	@PostMapping(value = "/saveEstado")
	public ResponseEntity<Estado> save(@RequestBody Estado estado) {
		Estado estadoReturn = estadoService.save(estado);
		return new ResponseEntity<Estado>(estadoReturn, HttpStatus.OK);
	}

	@GetMapping(value = "/deleteEstado/{id}")
	public ResponseEntity<Estado> delete(@PathVariable Long id){
		Estado estado = estadoService.get(id);
		if(estado != null) {
			estadoService.delete(id);
		}else {
			return new ResponseEntity<Estado>(estado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
}
