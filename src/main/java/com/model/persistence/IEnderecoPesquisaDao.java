package com.model.persistence;

import java.util.List;

import com.model.entidades.base.EnderecoPesquisa;

public interface IEnderecoPesquisaDao extends GenericDAO<EnderecoPesquisa, Long> {

	EnderecoPesquisa buscarPorCep(String cep);

	List<String> listarTiposLogradouros();

	List<String> listarNomesLogradouros(EnderecoPesquisa obj);
}
