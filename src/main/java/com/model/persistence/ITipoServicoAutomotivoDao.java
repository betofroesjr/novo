package com.model.persistence;

import com.model.entidades.base.TipoServicoAutomotivo;

public interface ITipoServicoAutomotivoDao extends GenericDAO<TipoServicoAutomotivo, Long> {
	
	public void salvar(TipoServicoAutomotivo obj);

}
