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

import com.estonianport.demo.model.Persona;
import com.estonianport.demo.service.PersonaService;

@RestController
@RequestMapping(value = "/rest")
public class PersonaRest {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping(value = "/findPersona/{id}")
	public Persona find(@PathVariable Long id){
		return personaService.get(id);
	}

	@GetMapping(value = "/allPersona")
	public List<Persona> getAll(){
		return personaService.getAll();
	}

	@PostMapping(value = "/savePersona")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona personaReturn = personaService.save(persona);
		return new ResponseEntity<Persona>(personaReturn, HttpStatus.OK);
	}
	
	@GetMapping(value = "/deletePersona/{id}")
	public ResponseEntity<Persona> delete(@PathVariable Long id){
		Persona persona = personaService.get(id);
		if(persona != null) {
			personaService.delete(id);
		}else {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
}
