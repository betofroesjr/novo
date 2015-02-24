package com.model.entidades.seguranca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.model.entidades.base.Foo;

@Entity
@Table(name="permissao")
public class Permissao extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6487788084348057616L;
	
	private String descricao;
	private Boolean autorizacao;
	
	@ManyToMany(targetEntity=TipoUsuario.class, mappedBy="permissao", fetch=FetchType.LAZY)
	@Foo
	private List<TipoUsuario> tipoUsuarios;
		
	public Permissao() {
		super();
		this.descricao = "";
		this.autorizacao = false;
		this.tipoUsuarios = new ArrayList<>();
	}
	
	public Permissao(String descricao, Boolean autorizacao,
			List<TipoUsuario> tipoUsuarios) {
		super();
		this.descricao = descricao;
		this.autorizacao = autorizacao;
		this.tipoUsuarios = tipoUsuarios;
	}

	public List<TipoUsuario> getTipoUsuarios() {
		return tipoUsuarios;
	}
	public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
		this.tipoUsuarios = tipoUsuarios;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(Boolean autorizacao) {
		this.autorizacao = autorizacao;
	}

}
