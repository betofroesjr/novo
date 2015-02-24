package com.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.entidades.base.Usuario;

@Service("autenticadorService")
public class AutenticadorService implements IAutenticadorService {

	@Autowired
	private IUsuarioService userServ;

	@Override
	public Usuario autentica(String login, String senha) throws Exception {
		try{
			Usuario usuario = userServ.procurarPorLoginSenha(login, senha);			
			return usuario;
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * @return the usuarioServico
	 */
	public IUsuarioService getUserServ() {
		return userServ;
	}

	/**
	 *@param usuarioServico the usuarioServico to set
	*/
	public void setUserServ(IUsuarioService userServ) {
		this.userServ = userServ;
	}

	@Override
	public void desanexar(Usuario usuario) {
		userServ.desanexar(usuario);
	}

	@Override
	public Usuario procurarPorLogin(String login) {		
		return userServ.procurarPorLogin(login);
	}
	
	
}
