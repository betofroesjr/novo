package com.model.servico;

import java.util.List;

import com.model.entidades.seguranca.LogSistema;

public interface ILogSistemaService {
	void salvar(LogSistema obj);

	void remover(LogSistema obj);
	void alterar(LogSistema obj);
	List<LogSistema> lista();
	LogSistema procurarPorId(Long id);
}
