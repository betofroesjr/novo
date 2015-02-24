package com.model.servico;

import java.util.List;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;


public interface ITipoUsuarioService {
	void salvar(TipoUsuario obj);
	void remover(TipoUsuario obj);
	void alterar(TipoUsuario obj);
	List<TipoUsuario> lista();
	TipoUsuario procurarPorId(Long id);
	List<Permissao> carregarListaCompleta(TipoUsuario editado);
	TipoUsuario procurarPorDescricao(String string);
}
