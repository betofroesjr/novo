package com.model.persistence;

import java.util.List;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;

public interface ICidadeDao extends GenericDAO<Cidade, Long> {

	public void salvar(Cidade obj);

	public Cidade procurarPorNome(String nomeCidade);

	public List<Cidade> procurarPorCidade(Long id);

	public List<Bairro> listarPorCidade(Long id);
}
