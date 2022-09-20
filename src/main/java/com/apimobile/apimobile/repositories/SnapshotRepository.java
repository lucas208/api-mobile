package com.apimobile.apimobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimobile.apimobile.entities.Snapshot;

public interface SnapshotRepository extends JpaRepository<Snapshot, Integer> {
    
}