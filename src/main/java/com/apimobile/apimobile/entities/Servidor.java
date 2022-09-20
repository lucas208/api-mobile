package com.apimobile.apimobile.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "servidores")
public class Servidor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    private String nome;
    
    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String matricula;

    @OneToMany(mappedBy = "servidor")
    private List<Vinculo> vinculos = new ArrayList<>();

    public void addVinculo(Vinculo novoVinculo) {
		vinculos.add(novoVinculo);
		novoVinculo.setServidor(this);
	}

	public void removeVinculo(Vinculo removeVinculo) {
		vinculos.remove(removeVinculo);
		removeVinculo.setServidor(null);
	}
    
}