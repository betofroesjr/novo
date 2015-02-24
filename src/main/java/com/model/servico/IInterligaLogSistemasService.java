package com.model.servico;

import java.util.List;

import com.model.entidades.seguranca.InterligaLogSistemas;

public interface IInterligaLogSistemasService {
	void salvar(InterligaLogSistemas obj);
	void remover(InterligaLogSistemas obj);
	void alterar(InterligaLogSistemas obj);
	List<InterligaLogSistemas> lista();
	InterligaLogSistemas procurarPorId(Long id);
}
