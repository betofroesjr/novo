package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.Pessoa;
import com.model.entidades.base.Telefone;
import com.model.persistence.ITelefoneDao;

@Service
public class TelefoneService implements ITelefoneService{

	@Autowired
	private ITelefoneDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=false,rollbackFor = Exception.class)
	public void salvar(Telefone obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Telefone obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Telefone obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Telefone> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Telefone procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Telefone> listarPorPessoa(Pessoa pessoa) {
		return dao.listarPorPessoa(pessoa);
	}
	
	
}
