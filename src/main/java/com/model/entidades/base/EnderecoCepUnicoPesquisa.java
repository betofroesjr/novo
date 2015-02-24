package com.model.entidades.base;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco_cep_unico_pesquisa")
public class EnderecoCepUnicoPesquisa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1292585438305497230L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String CEP;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_cidade", nullable=false)
	private Cidade cidade;

	/**
	 * @return o id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id o id a ser configurado
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return o cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * @param cidade o cidade a ser configurado
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return o cEP
	 */
	public String getCEP() {
		return CEP;
	}

	/**
	 * @param cEP o cEP a ser configurado
	 */
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	
}
