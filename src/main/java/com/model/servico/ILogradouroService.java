package com.model.servico;

import java.util.List;

import com.model.entidades.base.Logradouro;

public interface ILogradouroService {
	void salvar(Logradouro obj);
	void remover(Logradouro obj);
	void alterar(Logradouro obj);
	List<Logradouro> lista();
	Logradouro procurarPorId(Long id);
	List<Logradouro> logradouroPorPessoa(Long id);
	Logradouro procurarPorObjeto(Logradouro obj);
	Logradouro procurarPorEnderecoAtual(Long id);
}
