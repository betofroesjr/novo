package com.model.servico;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.Fornecedor;
import com.model.persistence.IFornecedorDao;

@Service
public class FornecedorService implements IFornecedorService{
	
	@Autowired private IFornecedorDao dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(Fornecedor obj) {
		dao.salvar(obj);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Fornecedor obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Fornecedor obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Fornecedor> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Fornecedor procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Fornecedor procurarPorDescricao(String descricao) {
		return dao.procurarPorDescricao(descricao);
	}	
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Fornecedor> listaFornecedoresPorIdTipoFornecedor(Long id) {
		return dao.listaFornecedoresPorIdTipoFornecedor(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Fornecedor buscarPorObjeto(Fornecedor obj) {
		return dao.buscarPorObjeto(obj);
	}
}