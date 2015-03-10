package com.model.servico;
import java.util.List;
import com.model.entidades.base.Fornecedor;

public interface IFornecedorService{
	void salvar(Fornecedor obj);
	void remover(Fornecedor obj);
	void alterar(Fornecedor obj);
	List<Fornecedor> lista();
	List<Fornecedor> listaFornecedoresPorIdTipoFornecedor(Long id);
	Fornecedor procurarPorId(Long id);
	Fornecedor procurarPorDescricao(String descricao);
	Fornecedor buscarPorObjeto(Fornecedor obj);
}
