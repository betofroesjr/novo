package com.model.persistence;
import java.util.List;

import com.model.entidades.base.Fornecedor;

public interface IFornecedorDao extends GenericDAO<Fornecedor, Long>{
	public void salvar(Fornecedor obj);
	public Fornecedor procurarPorDescricao(String descricao);	
	public List<Fornecedor> listaFornecedoresPorIdTipoFornecedor(Long id);
}
