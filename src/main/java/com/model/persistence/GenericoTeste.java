package com.model.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class GenericoTeste extends GenericDAOImpl<Object, Long> implements IGenericoTeste {

	@Override
	public void salvar(Object entidade) {
		
	}

	
}
