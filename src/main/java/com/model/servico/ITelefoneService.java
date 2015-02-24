package com.model.servico;

import java.util.List;

import com.model.entidades.base.Pessoa;
import com.model.entidades.base.Telefone;

public interface ITelefoneService {
	void salvar(Telefone obj);
	void remover(Telefone obj);
	void alterar(Telefone obj);
	List<Telefone> lista();
	Telefone procurarPorId(Long id);
	List<Telefone> listarPorPessoa(Pessoa pessoa);
}
