package com.model.persistence;

import com.model.entidades.base.TipoPessoa;

public interface ITipoPessoaDao extends GenericDAO<TipoPessoa, Long> {

	public void salvar(TipoPessoa obj);

	public TipoPessoa buscarPorDescricao(String descricao);
}
