package com.model.servico;

import java.util.List;

import com.model.entidades.base.TipoPessoa;

public interface ITipoPessoaService {
	void salvar(TipoPessoa obj);
	void remover(TipoPessoa obj);
	void alterar(TipoPessoa obj);
	List<TipoPessoa> lista();
	TipoPessoa procurarPorId(Long id);
	TipoPessoa buscarPorDescricao(String descricao);
}
