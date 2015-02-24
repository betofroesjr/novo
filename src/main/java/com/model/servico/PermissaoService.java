package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;
import com.model.persistence.IPermissaoDao;

@Service
public class PermissaoService implements IPermissaoService{
	
	@Autowired
	private IPermissaoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(Permissao obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Permissao obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Permissao obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Permissao> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Permissao procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Boolean procurarPorPermissao(String descricao) {
		return dao.procurarPorPermissao(descricao);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Permissao procurarPorPermissaoRetornandoPermissao(String descricao) {
		return dao.procurarPorPermissaoRetornandoPermissao(descricao);
	}

	@Override
	public List<Permissao> procurarPorTipoUsuario(TipoUsuario tipo) {
		return dao.procurarPorTipoUsuario(tipo);
	}
	
	
}
