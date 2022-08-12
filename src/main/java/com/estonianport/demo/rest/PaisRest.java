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

import com.estonianport.demo.model.Pais;
import com.estonianport.demo.service.PaisService;

@RestController
@RequestMapping(value = "/rest")
public class PaisRest {

	@Autowired
	private PaisService paisService;

	@GetMapping(value = "/findPais/{id}")
	public Pais find(@PathVariable Long id){
		return paisService.get(id);
	}

	@GetMapping(value = "/allPais")
	public List<Pais> getAll(){
		return paisService.getAll();
	}

	@PostMapping(value = "/savePais")
	public ResponseEntity<Pais> save(@RequestBody Pais pais) {
		Pais paisReturn = paisService.save(pais);
		return new ResponseEntity<Pais>(paisReturn, HttpStatus.OK);
	}

	@GetMapping(value = "/deletePais/{id}")
	public ResponseEntity<Pais> delete(@PathVariable Long id){
		Pais pais = paisService.get(id);
		if(pais != null) {
			paisService.delete(id);
		}else {
			return new ResponseEntity<Pais>(pais, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pais>(pais, HttpStatus.OK);
	}
}
