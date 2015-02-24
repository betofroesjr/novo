package com.model.persistence;

import java.util.List;

import com.model.entidades.base.Logradouro;

public interface ILogradouroDao extends GenericDAO<Logradouro, Long> {

	public void salvar(Logradouro obj);
	public List<Logradouro> logradouroPorPessoa(Long id);
	public Logradouro procurarPorObjeto(Logradouro obj);
	public Logradouro procurarPorEnderecoAtual(Long id);	
}
