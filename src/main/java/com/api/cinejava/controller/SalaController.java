package com.api.cinejava.controller;

import com.api.cinejava.dto.SalaDto;
import com.api.cinejava.model.SalaModel;
import com.api.cinejava.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping("/{id}")
    public ResponseEntity<SalaModel> findById(@PathVariable Integer id) {
        SalaModel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping
    public ResponseEntity<List<SalaDto>> findAll() {
        List<SalaModel> list = service.findAll();
        List<SalaDto> listDto = list.stream().map(obj -> new SalaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


}
