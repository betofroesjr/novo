package com.model.persistence;

import java.util.List;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;

public interface IPermissaoDao extends GenericDAO<Permissao, Long>{
	
	public void salvar(Permissao obj);
	public Boolean procurarPorPermissao(String descricao);
	public List<Permissao> procurarPorTipoUsuario(TipoUsuario tipo);
	public Permissao procurarPorPermissaoRetornandoPermissao(String descricao);

}
