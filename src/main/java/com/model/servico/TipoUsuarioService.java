package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;
import com.model.persistence.ITipoUsuarioDao;

@Service
public class TipoUsuarioService implements ITipoUsuarioService {
	
	@Autowired private ITipoUsuarioDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(TipoUsuario obj) {
		dao.salvar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(TipoUsuario obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(TipoUsuario obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TipoUsuario> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TipoUsuario procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	public List<Permissao> carregarListaCompleta(TipoUsuario editado) {
		return dao.carregarListaCompleta(editado);
	}

	@Override
	public TipoUsuario procurarPorDescricao(String string) {
		return dao.procurarPorDescricao(string);
	}	
}
