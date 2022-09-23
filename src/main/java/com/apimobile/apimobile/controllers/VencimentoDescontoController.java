package com.apimobile.apimobile.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
	@Autowired
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

	@GetMapping(value = "/{id}/{inicio}/{fim}")
    public ResponseEntity<List<VencimentoDesconto>> gerarFicha(@PathVariable Integer id, @PathVariable String inicio, @PathVariable String fim){
		LocalDate dataInicial = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate dataFinal = LocalDate.parse(fim, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<VencimentoDesconto> obj = service.buscarContrachequeByReferencia(id, dataInicial, dataFinal);
        return ResponseEntity.ok().body(obj);
    }
}