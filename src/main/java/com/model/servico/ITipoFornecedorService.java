package com.model.servico;
import java.util.List;
import com.model.entidades.base.TipoFornecedor;

public interface ITipoFornecedorService {
	void salvar(TipoFornecedor obj);
	void remover(TipoFornecedor obj);
	void alterar(TipoFornecedor obj);
	List<TipoFornecedor> lista();
	TipoFornecedor procurarPorId(Long id);
	TipoFornecedor procurarPorDescricao(String descricao);
}
