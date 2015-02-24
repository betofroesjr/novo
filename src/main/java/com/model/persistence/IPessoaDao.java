package com.model.persistence;

import com.model.entidades.base.Pessoa;

public interface IPessoaDao extends GenericDAO<Pessoa, Long> {

	public void salvar(Pessoa obj);
	public Pessoa procurarPorObjeto(Pessoa obj);
}
