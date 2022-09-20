package com.apimobile.apimobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimobile.apimobile.entities.Vinculo;
import com.apimobile.apimobile.repositories.VinculoRepository;
import com.apimobile.apimobile.services.exceptions.ResourceNotFoundException;

@Service
public class VinculoService {

    @Autowired
    private VinculoRepository repository;
    
    public List<Vinculo> findAll(){
		return repository.findAll();
	}
	
	public Vinculo findById(Integer id) {
		Optional<Vinculo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}