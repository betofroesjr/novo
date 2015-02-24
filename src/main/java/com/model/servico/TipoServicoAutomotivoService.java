package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.TipoServicoAutomotivo;
import com.model.persistence.ITipoServicoAutomotivoDao;

@Service
public class TipoServicoAutomotivoService implements ITipoServicoAutomotivoService {

	@Autowired	private ITipoServicoAutomotivoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(TipoServicoAutomotivo obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(TipoServicoAutomotivo obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(TipoServicoAutomotivo obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TipoServicoAutomotivo> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TipoServicoAutomotivo procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	
}
