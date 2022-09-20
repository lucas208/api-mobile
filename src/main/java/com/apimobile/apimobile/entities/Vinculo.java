package com.apimobile.apimobile.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vinculos")
public class Vinculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_nomeacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNomeacao;

	@Column(name = "data_posse")
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPosse;

	@Column(name = "data_exercicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataExercicio;

	private String categoria;

	@Column(name = "regime_juridico")
	private String regimeJuridico;

	private String tipo;

	@Column(name = "unidade_organizacional")
	private String unidadeOrganizacional;

	@ManyToOne
	@JoinColumn(name = "servidor_id")
	private Servidor servidor;

    @OneToMany(mappedBy = "vinculo")
    private List<VencimentoDesconto> contracheques = new ArrayList<>();

    public void addContracheque(VencimentoDesconto vencimentoDesconto) {
		contracheques.add(vencimentoDesconto);
		vencimentoDesconto.setVinculo(this);
	}

	public void removeContracheque(VencimentoDesconto vencimentoDesconto) {
		contracheques.remove(vencimentoDesconto);
		vencimentoDesconto.setVinculo(null);
	}

}