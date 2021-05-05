package com.api.cinejava.controller;


import com.api.cinejava.dto.FilmeDto;
import com.api.cinejava.dto.SessaoDto;
import com.api.cinejava.model.FilmeModel;
import com.api.cinejava.model.SessaoModel;
import com.api.cinejava.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping
    public ResponseEntity<List<SessaoDto>> findAllBySala(@RequestParam(value = "sala", defaultValue = "0") Integer id_ses) {
        List<SessaoModel> list = service.findAllBySala(id_ses);
        List<SessaoDto> listDto = list.stream().map(obj -> new SessaoDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value="/all")
    public ResponseEntity<List<SessaoDto>> findAll(){
        List<SessaoModel> list = service.findAll();
        List<SessaoDto> listDto = list.stream().map(obj -> new SessaoDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


    @PostMapping
    public ResponseEntity<SessaoModel> create( @RequestParam(value = "sala", defaultValue = "0") Integer id_cat,
                                               @RequestParam(value = "filme", defaultValue = "0") Integer id_filme,
                                              @Valid @RequestBody SessaoModel obj) {
        SessaoModel newObj = service.create(id_cat,id_filme, obj);
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
