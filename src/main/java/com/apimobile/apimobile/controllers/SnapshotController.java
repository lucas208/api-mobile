package com.apimobile.apimobile.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apimobile.apimobile.entities.Snapshot;
import com.apimobile.apimobile.services.SnapshotService;

@RestController
@RequestMapping(value = "/snapshots")
public class SnapshotController {
    
    private SnapshotService service;

    @GetMapping
	public ResponseEntity<List<Snapshot>> findAll(){
		List<Snapshot> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Snapshot> findById(@PathVariable Integer id){
		Snapshot obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}