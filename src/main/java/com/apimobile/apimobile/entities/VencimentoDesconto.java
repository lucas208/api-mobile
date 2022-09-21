package com.apimobile.apimobile.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String codigo;
    private String descricao;
    private BigDecimal valor;
    private String tipo;

    @JsonFormat(pattern = "MM/yyyy")
    private LocalDate referencia;

    @JsonIgnore
    @ManyToOne
	@JoinColumn(name = "vinculo_id")
	private Snapshot snapshot;

    public VencimentoDesconto(String codigo, String descricao, BigDecimal valor, String tipo, String referencia) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.referencia = LocalDate.parse(referencia, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}