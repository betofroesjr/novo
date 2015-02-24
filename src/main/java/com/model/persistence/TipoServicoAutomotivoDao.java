package com.model.persistence;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.TipoServicoAutomotivo;

@Repository
public class TipoServicoAutomotivoDao extends GenericDAOImpl<TipoServicoAutomotivo, Long> implements ITipoServicoAutomotivoDao {

	@Override
	public void salvar(TipoServicoAutomotivo obj) {
		em.persist(obj);
	}

}
