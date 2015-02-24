package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.Logradouro;
import com.model.persistence.ILogradouroDao;

@Service
public class LogradouroService implements ILogradouroService {

	@Autowired
	private ILogradouroDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=false, rollbackFor = Exception.class)
	public void salvar(Logradouro obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Logradouro obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Logradouro obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Logradouro> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Logradouro procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Logradouro> logradouroPorPessoa(Long id) {
		return dao.logradouroPorPessoa(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Logradouro procurarPorObjeto(Logradouro obj) {
		return dao.procurarPorObjeto(obj);
	}

	@Override
	public Logradouro procurarPorEnderecoAtual(Long id) {
		return dao.procurarPorEnderecoAtual(id);
	}
}
