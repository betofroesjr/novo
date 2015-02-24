package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;
import com.model.persistence.ICidadeDao;

@Service
public class CidadeService implements ICidadeService {

	@Autowired ICidadeDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(Cidade obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Cidade obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Cidade obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Cidade> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cidade procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cidade procurarPorNome(String nomeCidade) {
		return dao.procurarPorNome(nomeCidade) ;
	}

	@Override
	public List<Cidade> procurarPorCidade(Long id) {
		return dao.procurarPorCidade(id);
	}

	@Override
	public List<Bairro> listarPorCidade(Long id) {
		return dao.listarPorCidade(id);
	}
}
