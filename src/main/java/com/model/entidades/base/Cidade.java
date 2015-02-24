package com.model.entidades.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.model.entidades.seguranca.Auditoria;


@Entity
@Table(name="cidade")
public class Cidade extends Auditoria {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5972509968453577108L;

	private String nomeCidade;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_estado", nullable=false)
	@ForeignKey(name="fk_cidade_estado")
	private Estado estado;
	
	@OneToMany(mappedBy="cidade")
	@Foo
	private List<Bairro> bairros;
	
	public Cidade() {
		super();
		this.nomeCidade = "";
		this.estado = new Estado();
	}
	
	public Cidade(String nomeCidade, Estado estado) {
		super();
		this.nomeCidade = nomeCidade;
		this.estado = estado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	}

	
}
