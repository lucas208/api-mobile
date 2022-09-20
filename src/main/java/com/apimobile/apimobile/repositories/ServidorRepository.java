package com.apimobile.apimobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimobile.apimobile.entities.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Integer> {
    
}