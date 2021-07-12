package com.api.cinejava.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.cinejava.model.UsuarioModel;
import com.api.cinejava.service.UsuarioService;



@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired 
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll(){
		List<UsuarioModel> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
    @PostMapping
    public ResponseEntity<UsuarioModel> create(@Valid @RequestBody UsuarioModel obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
