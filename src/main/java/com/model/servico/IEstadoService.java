package com.model.servico;

import java.util.List;

import com.model.entidades.base.Estado;

public interface IEstadoService {
	void salvar(Estado obj);
	void remover(Estado obj);
	void alterar(Estado obj);
	List<Estado> lista();
	Estado procurarPorId(Long id);
	Estado procurarPorNome(String nomeEstado);
	Estado procurarPorCidade(Long id);
}
