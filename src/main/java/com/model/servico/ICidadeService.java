package com.model.servico;

import java.util.List;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;

public interface ICidadeService {
	void salvar(Cidade obj);
	void remover(Cidade obj);
	void alterar(Cidade obj);
	List<Cidade> lista();
	Cidade procurarPorId(Long id);
	Cidade procurarPorNome(String nomeCidade);
	List<Cidade> procurarPorCidade(Long id);
	List<Bairro> listarPorCidade(Long id);
}
