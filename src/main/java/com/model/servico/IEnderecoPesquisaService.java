package com.model.servico;

import java.util.List;

import com.model.entidades.base.EnderecoPesquisa;


public interface IEnderecoPesquisaService {
	void salvar(EnderecoPesquisa obj);
	void remover(EnderecoPesquisa obj);
	void alterar(EnderecoPesquisa obj);
	List<EnderecoPesquisa> lista();
	EnderecoPesquisa procurarPorId(Long id);
	EnderecoPesquisa buscarPorCep(String cep);
	List<String> listarTiposLogradouros();
	List<String> listarNomesLogradouros(EnderecoPesquisa obj);
	
}
