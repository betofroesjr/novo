package com.model.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entidades.base.Usuario;
import com.model.persistence.IUsuarioDao;
import com.util.SpringContainer;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired	private IUsuarioDao usDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(Usuario usuario) {
		usuario.setTipoUser(true);
		if(usuario.getLogin().equals("admin")){
			usuario.setTipoAdm(true);
			usuario.setTipoDesenv(true);//TODO Mundar para outro usuario depois
		}
		usDao.salvar(usuario);		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario procurarPorLoginSenha(String login, String senha) {
		return usDao.procurarPorLoginSenha(login, senha);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void remover(Usuario usuario) {
		usDao.remover(usuario, usuario.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void alterar(Usuario usuario) {
		/*usuario.getPessoa().setDataAlteracao(new Date(System.currentTimeMillis()));	*/	
		usDao.alterar(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario procurarPorId(Long id) {
		return usDao.buscarPorId(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void desanexar(Usuario usuario) {
		usDao.desanexarUsuario(usuario);		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario procurarPorLogin(String login) {
		return usDao.procurarPorLogin(login);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void limparDadosJPA() {
		usDao.limparDadosJPA();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario procurarPorTipoUsuario(Long id) {
		return usDao.procurarPorTipoUsuario(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void refresh(Usuario usuario) {
		usDao.refresh(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Usuario> listar() {
		return usDao.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void testeDetach(Usuario obj) {
		usDao.testeDetach(obj);
	}
	
	/**
	* @return PessoaServico
	*/
	public static UsuarioService getInstancia() {
		return (UsuarioService) SpringContainer.getInstancia().getBean("pessoaServico");
	}

	@Override
	public void fecharSessaoJPA() {
		usDao.fecharSessaoJPA();
	}
}
