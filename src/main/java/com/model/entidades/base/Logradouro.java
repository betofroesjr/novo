package com.model.entidades.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="logradouro")
public class Logradouro extends Auditoria {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4148290004014902937L;	
	private String nomeLogradouro;
	private String numeroLote;
	private String quadra; 
	private String lote;
	private String complemento;
	private String cep; 
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_bairro")
	@ForeignKey(name="fk_logradouro_bairro")
	private Bairro bairro;
	
	@ManyToMany(targetEntity=Pessoa.class, cascade={CascadeType.MERGE, CascadeType.REFRESH})	
	@JoinColumn(name="id_pessoa", nullable=false)
	@Foo
	private List<Pessoa> pessoa;
	
	private Boolean enderecoAtual;

	public Logradouro() {
		super();		
		this.nomeLogradouro = "";
		this.numeroLote = "";
		this.quadra = "";
		this.lote = "";
		this.complemento = "";
		this.cep = "";
		this.bairro = new Bairro();
		this.pessoa = new ArrayList<>();
		this.enderecoAtual = false;
	}	

	public Logradouro(String nomeLogradouro, String numeroLote, String quadra,
			String lote, String complemento, String cep, Bairro bairro,
			List<Pessoa> pessoa, Boolean enderecoAtual) {
		super();
		this.nomeLogradouro = nomeLogradouro;
		this.numeroLote = numeroLote;
		this.quadra = quadra;
		this.lote = lote;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.pessoa = pessoa;
		this.enderecoAtual = enderecoAtual;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return o enderecoAtual
	 */
	public Boolean getEnderecoAtual() {
		return enderecoAtual;
	}

	/**
	 * @param enderecoAtual o enderecoAtual a ser configurado
	 */
	public void setEnderecoAtual(Boolean enderecoAtual) {
		this.enderecoAtual = enderecoAtual;
	}
	
	
}
