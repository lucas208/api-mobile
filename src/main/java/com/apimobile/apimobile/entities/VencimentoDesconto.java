package com.apimobile.apimobile.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vencimentosdescontos")
public class VencimentoDesconto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String codigo;

    private String descricao;
    private BigDecimal valor;
    private String tipo;

    @JsonFormat(pattern = "MM/yyyy")
    private LocalDate referencia;

    @ManyToOne
	@JoinColumn(name = "vinculo_id")
	private Snapshot snapshot;

}