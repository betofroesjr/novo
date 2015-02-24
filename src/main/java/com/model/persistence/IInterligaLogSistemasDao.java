package com.model.persistence;

import com.model.entidades.seguranca.InterligaLogSistemas;

public interface IInterligaLogSistemasDao extends GenericDAO<InterligaLogSistemas, Long> {
	public void salvar(InterligaLogSistemas obj);
}
