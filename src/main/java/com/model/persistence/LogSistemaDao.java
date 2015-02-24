package com.model.persistence;

import org.springframework.stereotype.Repository;

import com.model.entidades.seguranca.LogSistema;

@Repository
public class LogSistemaDao extends GenericDAOImpl<LogSistema, Long> implements ILogSistemaDao {

	@Override
	public void salvar(LogSistema obj) {
		em.persist(obj);		
	}

}
