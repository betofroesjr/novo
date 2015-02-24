package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.EnderecoCepUnicoPesquisa;
import com.model.persistence.IEnderecoCepUnicoPesquisaDao;

@Service
public class EnderecoCepUnicoPesquisaService implements IEnderecoCepUnicoPesquisaService{

	@Autowired IEnderecoCepUnicoPesquisaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(EnderecoCepUnicoPesquisa obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void remover(EnderecoCepUnicoPesquisa obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void alterar(EnderecoCepUnicoPesquisa obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EnderecoCepUnicoPesquisa> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EnderecoCepUnicoPesquisa procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	public EnderecoCepUnicoPesquisa buscarPorCep(String cep) {
		return dao.buscarPorCep(cep);
	}
}
