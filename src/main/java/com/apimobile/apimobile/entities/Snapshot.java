package com.apimobile.apimobile.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Snapshot implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer vinculoId;

    @Column(name = "nome")
    private String servidorNome;

    @Column(name = "cpf")
    private String servidorCpf;

    @Column(name = "matricula")
    private String servidorMatricula;

    @Column(name = "orgao")
    private String vinculoOrgao;

    @Column(name = "setor")
    private String vinculoSetor;

    @Column(name = "codigo_cargo")
    private String vinculoCodigoCargo;

    @Column(name = "descricao_cargo")
    private String vinculoDescricaoCargo;

    @Column(name = "unidade_organizacional")
    private String vinculoUnidadeOrganizacional;

    @JsonFormat(pattern = "MM/yyyy")
    private LocalDate referencia;

    @OneToMany(mappedBy = "snapshot", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VencimentoDesconto> contracheque = new ArrayList<>();

    public void addVencimentoDesconto(VencimentoDesconto novo) {
		contracheque.add(novo);
		novo.setSnapshot(this);
	}

	public void removeVencimentoDesconto(VencimentoDesconto alvo) {
		contracheque.remove(alvo);
		alvo.setSnapshot(null);
	}

  public Snapshot(Integer vinculoId, String servidorNome, String servidorCpf, String servidorMatricula,
      String vinculoOrgao, String vinculoSetor, String vinculoCodigoCargo, String vinculoDescricaoCargo,
      String vinculoUnidadeOrganizacional, String referencia) {
    this.vinculoId = vinculoId;
    this.servidorNome = servidorNome;
    this.servidorCpf = servidorCpf;
    this.servidorMatricula = servidorMatricula;
    this.vinculoOrgao = vinculoOrgao;
    this.vinculoSetor = vinculoSetor;
    this.vinculoCodigoCargo = vinculoCodigoCargo;
    this.vinculoDescricaoCargo = vinculoDescricaoCargo;
    this.vinculoUnidadeOrganizacional = vinculoUnidadeOrganizacional;
    this.referencia = LocalDate.parse(referencia, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    this.contracheque = new ArrayList<>();
  }
}