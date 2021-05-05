package com.api.cinejava.controller;

import com.api.cinejava.dto.FilmeDto;
import com.api.cinejava.model.FilmeModel;
import com.api.cinejava.service.FilmeService;
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
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping("/{id}")
    public ResponseEntity<FilmeModel> findById(@PathVariable Integer id) {
        FilmeModel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
    @GetMapping
    public ResponseEntity<List<FilmeDto>> findAll(){
        List<FilmeModel> list = service.findAll();
        List<FilmeDto> listDto = list.stream().map(obj -> new FilmeDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<FilmeModel> create(@Valid @RequestBody FilmeModel obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FilmeDto> update(@PathVariable Integer id,@Valid @RequestBody FilmeDto objDto){
        FilmeModel newObj = service.update(id,objDto);
        return ResponseEntity.ok().body(new FilmeDto(newObj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
