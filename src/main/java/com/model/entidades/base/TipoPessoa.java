package com.model.entidades.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="tipo_pessoa")
public class TipoPessoa extends Auditoria {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2756490364031163713L;
	
	@Transient
	@Foo
	public static final String TIPO_PESSOA_MILITAR = "Militar";
	@Transient
	@Foo
	public static final String TIPO_PESSOA_CIVIL = "Civil";
	
	@Column(name="tipo_pessoa_descricao", unique=true , nullable=false)
	private String descricao;

	public TipoPessoa() {
		super();
		this.descricao = "";
	}	
	
	public TipoPessoa(Long id, String descricao) {
		super.setId(id);
		this.descricao = descricao;
	}
	
	public TipoPessoa(Long id) {
		super.setId(id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
