package com.model.persistence;

import com.model.entidades.base.Estado;

public interface IEstadoDao extends GenericDAO<Estado, Long>{

	public void salvar(Estado obj);

	public Estado procurarPorNome(String nomeEstado);

	public Estado procurarPorCidade(Long id);
}
