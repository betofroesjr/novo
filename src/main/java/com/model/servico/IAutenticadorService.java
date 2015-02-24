package com.model.servico;

import com.model.entidades.base.Usuario;

public interface IAutenticadorService {
	public Usuario autentica(String login, String senha) throws Exception;
	void desanexar(Usuario usuario);
	Usuario procurarPorLogin(String login);
}
