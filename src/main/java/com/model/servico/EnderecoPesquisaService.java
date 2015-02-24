package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.EnderecoPesquisa;
import com.model.persistence.IEnderecoPesquisaDao;

@Service
public class EnderecoPesquisaService implements IEnderecoPesquisaService {

	@Autowired private IEnderecoPesquisaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void salvar(EnderecoPesquisa obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void remover(EnderecoPesquisa obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void alterar(EnderecoPesquisa obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EnderecoPesquisa> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EnderecoPesquisa procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	public EnderecoPesquisa buscarPorCep(String cep) {
		return dao.buscarPorCep(cep);
	}

	@Override
	public List<String> listarTiposLogradouros() {
		return dao.listarTiposLogradouros();
	}

	@Override
	public List<String> listarNomesLogradouros(EnderecoPesquisa obj) {
		return dao.listarNomesLogradouros(obj);
	}


}
