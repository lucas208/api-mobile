package com.apimobile.apimobile.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	private String orgao;

	private String setor;

	@Column(name = "codigo_cargo")
    private String codigoCargo;

	@Column(name = "descricao_cargo")
	private String descricaoCargo;

	@Column(name = "unidade_organizacional")
	private String unidadeOrganizacional;

	@OneToOne
    @JoinColumn(name = "servidor_id")
	private Servidor servidor;

	public Vinculo(String orgao, String setor, String codigoCargo, String descricaoCargo, String unidadeOrganizacional,
			Servidor servidor) {
		this.orgao = orgao;
		this.setor = setor;
		this.codigoCargo = codigoCargo;
		this.descricaoCargo = descricaoCargo;
		this.unidadeOrganizacional = unidadeOrganizacional;
		this.servidor = servidor;
	}
}