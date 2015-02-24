package com.model.servico;

import java.util.List;

import com.model.entidades.base.Usuario;

public interface IUsuarioService {
	void salvar(Usuario usuario);
	Usuario procurarPorLogin(String login);
	Usuario procurarPorLoginSenha(String login, String senha);
	Usuario procurarPorId(Long id);
	Usuario procurarPorTipoUsuario(Long id);
	void remover(Usuario usuario);
	void alterar(Usuario usuario);
	void desanexar(Usuario usuario);
	void limparDadosJPA();
	void refresh(Usuario usuario);
	List<Usuario> listar();
	void testeDetach(Usuario obj);
	void fecharSessaoJPA();
}
