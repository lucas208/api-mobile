package com.apimobile.apimobile.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apimobile.apimobile.entities.Vinculo;
import com.apimobile.apimobile.services.VinculoService;

@RestController
@RequestMapping(value = "/vinculos")
public class VinculoController {
    
    private VinculoService service;

    @GetMapping
	public ResponseEntity<List<Vinculo>> findAll(){
		List<Vinculo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vinculo> findById(@PathVariable Integer id){
		Vinculo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}