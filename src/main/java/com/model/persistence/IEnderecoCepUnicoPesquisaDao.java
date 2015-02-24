package com.model.persistence;

import com.model.entidades.base.EnderecoCepUnicoPesquisa;

public interface IEnderecoCepUnicoPesquisaDao extends GenericDAO<EnderecoCepUnicoPesquisa, Long> {

	EnderecoCepUnicoPesquisa buscarPorCep(String cep);

}
