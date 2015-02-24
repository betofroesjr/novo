package com.model.persistence;

import org.springframework.stereotype.Repository;

import com.model.entidades.seguranca.InterligaLogSistemas;

@Repository
public class InterligaLogSistemasDao extends GenericDAOImpl<InterligaLogSistemas, Long> implements IInterligaLogSistemasDao{

	@Override
	public void salvar(InterligaLogSistemas obj) {
		em.persist(obj);
	}

}
