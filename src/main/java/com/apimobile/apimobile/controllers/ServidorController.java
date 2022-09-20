package com.apimobile.apimobile.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apimobile.apimobile.entities.Servidor;
import com.apimobile.apimobile.services.ServidorService;

@RestController
@RequestMapping(value = "/servidores")
public class ServidorController {
    
    private ServidorService service;

    @GetMapping
	public ResponseEntity<List<Servidor>> findAll(){
		List<Servidor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Servidor> findById(@PathVariable Integer id){
		Servidor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}