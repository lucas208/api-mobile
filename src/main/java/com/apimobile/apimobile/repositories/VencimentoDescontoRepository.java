package com.apimobile.apimobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimobile.apimobile.entities.VencimentoDesconto;

public interface VencimentoDescontoRepository extends JpaRepository<VencimentoDesconto, Integer> {
    
}