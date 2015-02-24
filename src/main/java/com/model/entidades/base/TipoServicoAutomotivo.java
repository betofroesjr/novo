package com.model.entidades.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="Tipo_Servico_Automotivo")
public class TipoServicoAutomotivo extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2294091645489880753L;
	
	@Column(name="Tipo_Servico_Automotivo_descricao", unique=true , nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private int status;

	public TipoServicoAutomotivo() {
		super();
		this.descricao = "";
		this.status = 0;
	}
	
	public TipoServicoAutomotivo(String descricao, int status) {
		super();
		this.descricao = descricao;
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}	
	
}
