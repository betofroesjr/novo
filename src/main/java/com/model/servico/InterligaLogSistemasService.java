package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.seguranca.InterligaLogSistemas;
import com.model.persistence.IInterligaLogSistemasDao;

@Service
@Transactional(readOnly = true, propagation = Propagation.NESTED)
public class InterligaLogSistemasService implements IInterligaLogSistemasService{

	@Autowired
	private IInterligaLogSistemasDao dao;

	@Override
	public void salvar(InterligaLogSistemas obj) {
		dao.salvar(obj);
	}

	@Override
	public void remover(InterligaLogSistemas obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	public void alterar(InterligaLogSistemas obj) {
		dao.alterar(obj);
	}

	@Override
	public List<InterligaLogSistemas> lista() {
		return dao.buscarTodos();
	}

	@Override
	public InterligaLogSistemas procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	
}
