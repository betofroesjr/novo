package com.model.entidades.base;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="tipo_fornecedor")
public class TipoFornecedor extends Auditoria{

	private static final long serialVersionUID = 1292139520869339352L;
	private String descricao;
	
	public TipoFornecedor() {
		super();
		this.setDescricao("");
	}
	
	public TipoFornecedor(String descricao) {
		super();
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
