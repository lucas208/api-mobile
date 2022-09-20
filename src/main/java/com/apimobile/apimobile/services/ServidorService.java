package com.apimobile.apimobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimobile.apimobile.entities.Servidor;
import com.apimobile.apimobile.repositories.ServidorRepository;
import com.apimobile.apimobile.services.exceptions.ResourceNotFoundException;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository repository;
    
    public List<Servidor> findAll(){
		return repository.findAll();
	}
	
	public Servidor findById(Integer id) {
		Optional<Servidor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}