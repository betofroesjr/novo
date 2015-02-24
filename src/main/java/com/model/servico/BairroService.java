package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;
import com.model.persistence.IBairroDao;

@Service
public class BairroService implements IBairroService {

	@Autowired private IBairroDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(Bairro obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Bairro obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Bairro obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Bairro> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Bairro procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Bairro procurarPorNome(String nomeBairro) {		
		return dao.procurarPorNome(nomeBairro) ;
	}

	@Override
	public Cidade procurarPorBairro(Long id) {
		return dao.procurarPorBairro(id);
	}

	@Override
	public List<Bairro> listarPorEstado(Long id) {
		return dao.listarPorEstado(id);
	}
}
