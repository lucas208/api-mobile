package com.apimobile.apimobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimobile.apimobile.entities.VencimentoDesconto;
import com.apimobile.apimobile.repositories.VencimentoDescontoRepository;
import com.apimobile.apimobile.services.exceptions.ResourceNotFoundException;

@Service
public class VencimentoDescontoService {

    @Autowired
    private VencimentoDescontoRepository repository;
    
    public List<VencimentoDesconto> findAll(){
		return repository.findAll();
	}
	
	public VencimentoDesconto findById(Integer id) {
		Optional<VencimentoDesconto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}