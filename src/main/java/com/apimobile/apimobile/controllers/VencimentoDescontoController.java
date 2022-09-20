package com.apimobile.apimobile.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apimobile.apimobile.entities.VencimentoDesconto;
import com.apimobile.apimobile.services.VencimentoDescontoService;

@RestController
@RequestMapping(value = "/vencimentosdescontos")
public class VencimentoDescontoController {
    
    private VencimentoDescontoService service;

    @GetMapping
	public ResponseEntity<List<VencimentoDesconto>> findAll(){
		List<VencimentoDesconto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VencimentoDesconto> findById(@PathVariable String id){
		VencimentoDesconto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}