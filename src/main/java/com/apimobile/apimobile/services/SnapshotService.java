package com.apimobile.apimobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimobile.apimobile.entities.Snapshot;
import com.apimobile.apimobile.repositories.SnapshotRepository;
import com.apimobile.apimobile.services.exceptions.ResourceNotFoundException;

@Service
public class SnapshotService {

    @Autowired
    private SnapshotRepository repository;
    
    public List<Snapshot> findAll(){
		return repository.findAll();
	}
	
	public Snapshot findById(Integer id) {
		Optional<Snapshot> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}