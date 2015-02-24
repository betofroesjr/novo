package com.model.servico;

import java.util.List;

import com.model.entidades.base.Pessoa;

public interface IPessoaService {

	void salvar(Pessoa obj);
	void remover(Pessoa obj);
	void alterar(Pessoa obj);
	List<Pessoa> lista();
	Pessoa procurarPorId(Long id);	
	Pessoa procurarPorObjeto(Pessoa obj);
}
