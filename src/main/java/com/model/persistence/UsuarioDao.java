
package com.model.persistence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.model.entidades.base.Usuario;


@Repository
public class UsuarioDao extends GenericDAOImpl<Usuario, Long> implements IUsuarioDao{

	@Override
	public void salvar(Usuario usuario){
		
		em.persist(usuario);		
	}

	@Override
	public Usuario procurarPorLoginSenha(String login, String senha){
		StringBuilder jpql = new StringBuilder();
		jpql.append("select usuario from Usuario usuario where usuario.login = :login AND usuario.senha = :senha");
		Query query = em.createQuery(jpql.toString(), Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		try {		
			Usuario obj = (Usuario) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			Usuario obj = new Usuario();
			return obj;
		}
	}

	@Override
	public void desanexarUsuario(Usuario usuario) {
		// Utilizar no login para ter duas o mais entidades de usuario		
		em.detach(usuario);		
	}

	@Override
	public Usuario procurarPorLogin(String login) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select usuario from Usuario usuario LEFT JOIN FETCH usuario.tipoUsuario where usuario.login = :login");
		Query query = em.createQuery(jpql.toString(), Usuario.class);
		query.setParameter("login", login);		
		try {		
			Usuario obj = (Usuario) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			Usuario obj = new Usuario();
			return obj;
		}
	}

	@Override
	public void limparDadosJPA() {
		em.flush();
		em.clear();
		em.getEntityManagerFactory().getCache().evictAll();
	}

	public void testeDetach(Usuario obj){
		org.hibernate.Session session = (Session) em.getDelegate();
		session.evict(obj);
		
	}
	
	@Override
	public Usuario procurarPorTipoUsuario(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select usuario from Usuario usuario LEFT JOIN FETCH usuario.tipoUsuario u1 where u1.id = :id");
		Query query = em.createQuery(jpql.toString(), Usuario.class);
		query.setParameter("id", id);		
		try {		
			Usuario obj = (Usuario) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			Usuario obj = new Usuario();
			return obj;
		}
	}
	
}
