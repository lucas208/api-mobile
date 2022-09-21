package com.apimobile.apimobile.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apimobile.apimobile.entities.VencimentoDesconto;

public interface VencimentoDescontoRepository extends JpaRepository<VencimentoDesconto, String> {
    
    @Query(value = "SELECT * FROM vencimentosdescontos vd WHERE vd.vinculo_id = ?1 AND vd.referencia >= ?2 AND vd.referencia < ?3", nativeQuery = true)
    List<VencimentoDesconto> buscarContrachequeByReferencia(Integer vinculoId, LocalDate inicio, LocalDate fim);
}