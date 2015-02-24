package com.model.persistence;

import com.model.entidades.base.Usuario;

public interface IUsuarioDao extends GenericDAO<Usuario, Long>{
	
	Usuario procurarPorLogin(String login);
	Usuario procurarPorLoginSenha(String login, String senha);
	void desanexarUsuario(Usuario usuario);
	void limparDadosJPA();
	Usuario procurarPorTipoUsuario(Long id);
	public void testeDetach(Usuario obj);
}
