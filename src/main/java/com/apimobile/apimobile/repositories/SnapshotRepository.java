package com.apimobile.apimobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apimobile.apimobile.entities.Snapshot;

public interface SnapshotRepository extends JpaRepository<Snapshot, Integer> {

    @Query(value = "SELECT new Snapshot(v.id, s.nome, s.cpf, s.matricula, v.orgao, v.setor, v.codigoCargo, v.descricaoCargo, v.unidadeOrganizacional, cast(:referencia as string)) FROM Servidor s, Vinculo v WHERE s.id = v.servidor.id")
    List<Snapshot> buscarComData(@Param("referencia") String referencia);

}