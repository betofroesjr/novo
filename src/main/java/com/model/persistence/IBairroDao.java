package com.model.persistence;

import java.util.List;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;

public interface IBairroDao extends GenericDAO<Bairro, Long>  {
	public void salvar(Bairro obj);

	public Bairro procurarPorNome(String nomeBairro);

	public Cidade procurarPorBairro(Long id);

	public List<Bairro> listarPorEstado(Long id);
}
