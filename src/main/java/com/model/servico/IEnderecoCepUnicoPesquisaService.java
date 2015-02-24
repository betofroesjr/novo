package com.model.servico;

import java.util.List;

import com.model.entidades.base.EnderecoCepUnicoPesquisa;

public interface IEnderecoCepUnicoPesquisaService {

	void salvar(EnderecoCepUnicoPesquisa obj);
	void remover(EnderecoCepUnicoPesquisa obj);
	void alterar(EnderecoCepUnicoPesquisa obj);
	List<EnderecoCepUnicoPesquisa> lista();
	EnderecoCepUnicoPesquisa procurarPorId(Long id);
	EnderecoCepUnicoPesquisa buscarPorCep(String cep);
}
