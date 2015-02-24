package com.model.servico;

import java.util.List;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;



public interface IBairroService {
	void salvar(Bairro obj);
	void remover(Bairro obj);
	void alterar(Bairro obj);
	List<Bairro> lista();
	Bairro procurarPorId(Long id);
	Bairro procurarPorNome(String nomeBairro);
	Cidade procurarPorBairro(Long id);
	List<Bairro> listarPorEstado(Long id);
}
