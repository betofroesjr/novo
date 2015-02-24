package com.model.persistence;

import com.model.entidades.seguranca.LogSistema;

public interface ILogSistemaDao extends GenericDAO<LogSistema, Long> {
	public void salvar(LogSistema obj);
}
