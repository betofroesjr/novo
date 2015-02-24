package com.model.entidades.base;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="bairro")
public class Bairro extends Auditoria{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7705578562591174561L;

	private String nomeBairro;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_cidade", nullable=false)
	@ForeignKey(name="fk_bairro_cidade")
	private Cidade cidade;

	public Bairro() {
		super();
		this.nomeBairro = "";
		this.cidade = new Cidade();
	}

	public Bairro(String nomeBairro, Cidade cidade) {
		super();
		this.nomeBairro = nomeBairro;
		this.cidade = cidade;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((nomeBairro == null) ? 0 : nomeBairro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bairro other = (Bairro) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (nomeBairro == null) {
			if (other.nomeBairro != null)
				return false;
		} else if (!nomeBairro.equals(other.nomeBairro))
			return false;
		return true;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bairro [nomeBairro=" + nomeBairro + ", cidade=" + cidade + "]";
	}

	
}
