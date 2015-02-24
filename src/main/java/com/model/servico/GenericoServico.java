package com.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.persistence.IGenericoTeste;

@Service
public class GenericoServico implements IGenericoServico{

	@Autowired IGenericoTeste generico;

	@Override
	@Transactional(propagation = Propagation.NESTED, readOnly = false)
	public void executarScprit(String string) {
		generico.executarScprit(string);
	}
	
	
}
