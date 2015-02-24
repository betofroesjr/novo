package com.model.entidades.base;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="telefone")
public class Telefone extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -245611620039753279L;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})	
	@JoinColumn(name="id_pessoa", nullable=false)
	@Foo
	private Pessoa pessoa;

	@Column(name="tipo_telefone")
	private String tipoTelefone;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="ramal")
	private String ramal;

	public Telefone() {
		super();
		this.pessoa = new Pessoa();
		this.tipoTelefone = "";
		this.numero = "";
		this.ramal = "";
	}

	public Telefone(Pessoa pessoa, String tipoTelefone, String numero,
			String ramal) {
		super();
		this.pessoa = pessoa;
		this.tipoTelefone = tipoTelefone;
		this.numero = numero;
		this.ramal = ramal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}	
	
}
