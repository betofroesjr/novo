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
@Table(name="endereco_pesquisa")
public class EnderecoPesquisa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -50744040698376885L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String tp_logradouro;
	private String logradouro;
	private String CEP;

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_bairro", nullable=false)
	private Bairro bairro;

	public EnderecoPesquisa() {
	}

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
	 * @return o tp_logradouro
	 */
	public String getTp_logradouro() {
		return tp_logradouro;
	}

	/**
	 * @param tp_logradouro o tp_logradouro a ser configurado
	 */
	public void setTp_logradouro(String tp_logradouro) {
		this.tp_logradouro = tp_logradouro;
	}

	/**
	 * @return o logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro o logradouro a ser configurado
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	/**
	 * @return o bairro
	 */
	public Bairro getBairro() {
		return bairro;
	}

	/**
	 * @param bairro o bairro a ser configurado
	 */
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CEP == null) ? 0 : CEP.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result
				+ ((tp_logradouro == null) ? 0 : tp_logradouro.hashCode());
		return result;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoPesquisa other = (EnderecoPesquisa) obj;
		if (CEP == null) {
			if (other.CEP != null)
				return false;
		} else if (!CEP.equals(other.CEP))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (tp_logradouro == null) {
			if (other.tp_logradouro != null)
				return false;
		} else if (!tp_logradouro.equals(other.tp_logradouro))
			return false;
		return true;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnderecoPesquisa [id=" + id + ", tp_logradouro="
				+ tp_logradouro + ", logradouro=" + logradouro + ", CEP=" + CEP
				+ "]";
	}

	
}
