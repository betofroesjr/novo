package com.model.entidades.base;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="fornecedor")
public class Fornecedor extends Auditoria{

	private static final long serialVersionUID = -6606926371961543456L;
	private String descricao;
	private String cnpj;
	private Integer status;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_tipofornecedor")
	private TipoFornecedor dados_Tipo_Fornecedor;
	
	public Fornecedor(){
		super();
		this.dados_Tipo_Fornecedor = null;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public TipoFornecedor getDados_Tipo_Fornecedor() {
		return dados_Tipo_Fornecedor;
	}
	public void setDados_Tipo_Fornecedor(TipoFornecedor dados_Tipo_Fornecedor) {
		this.dados_Tipo_Fornecedor = dados_Tipo_Fornecedor;
	}
}