package com.model.servico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.model.entidades.base.TipoFornecedor;
import com.model.persistence.ITipoFornecedorDao;

@Service
public class TipoFornecedorService implements ITipoFornecedorService{
	
	@Autowired private ITipoFornecedorDao dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(TipoFornecedor obj) {
		dao.salvar(obj);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(TipoFornecedor obj) {
		dao.remover(obj, obj.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(TipoFornecedor obj) {
		dao.alterar(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TipoFornecedor> lista() {
		return dao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TipoFornecedor procurarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TipoFornecedor procurarPorDescricao(String descricao) {
		return dao.procurarPorDescricao(descricao);
	}	
}
