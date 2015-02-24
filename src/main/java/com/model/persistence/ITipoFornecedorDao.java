package com.model.persistence;
import com.model.entidades.base.TipoFornecedor;

public interface ITipoFornecedorDao extends GenericDAO<TipoFornecedor, Long>{
	public void salvar(TipoFornecedor obj);
	public TipoFornecedor procurarPorDescricao(String descricao);	
}
