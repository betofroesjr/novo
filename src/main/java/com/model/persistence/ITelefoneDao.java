package com.model.persistence;

import java.util.List;

import com.model.entidades.base.Pessoa;
import com.model.entidades.base.Telefone;

public interface ITelefoneDao extends GenericDAO<Telefone, Long>{
	public void salvar(Telefone obj);
	public List<Telefone> listarPorPessoa(Pessoa pessoa);
}
