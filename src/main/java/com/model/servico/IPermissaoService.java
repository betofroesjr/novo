package com.model.servico;

import java.util.List;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;


public interface IPermissaoService {
	void salvar(Permissao obj);
	void remover(Permissao obj);
	void alterar(Permissao obj);
	List<Permissao> lista();
	Permissao procurarPorId(Long id);
	Boolean procurarPorPermissao(String descricao);
	List<Permissao> procurarPorTipoUsuario(TipoUsuario tipo);
	Permissao procurarPorPermissaoRetornandoPermissao(String string);
}
