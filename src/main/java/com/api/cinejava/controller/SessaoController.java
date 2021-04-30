package com.api.cinejava.controller;


import com.api.cinejava.model.SessaoModel;
import com.api.cinejava.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("/sessao")
public class SessaoController {
    @Autowired
    private SessaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SessaoModel> findById(@PathVariable Integer id) {
        SessaoModel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<SessaoModel> create( @RequestParam(value = "sala", defaultValue = "0") Integer id_cat,
                                               @RequestBody SessaoModel obj) {
        SessaoModel newObj = service.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/sessao/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<SessaoModel> update( @PathVariable Integer id, @Valid @RequestBody SessaoModel obj) {
        SessaoModel newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}
