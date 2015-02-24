package com.model.persistence;

import java.util.List;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;

public interface ITipoUsuarioDao extends GenericDAO<TipoUsuario, Long> {
	
	public void salvar(TipoUsuario obj);

	public List<Permissao> carregarListaCompleta(TipoUsuario editado);

	public TipoUsuario procurarPorDescricao(String string);

}
