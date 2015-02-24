package com.model.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;

@Repository
public class PermissaoDao extends GenericDAOImpl<Permissao, Long> implements IPermissaoDao{
	
	@Override
	public void salvar(Permissao obj) {
		em.persist(obj);
	}
	
	public Boolean procurarPorPermissao(String descricao){
		StringBuilder jpql = new StringBuilder();
		jpql.append("select obj.autorizacao from TipoProjetoAtendimento obj where obj.descricao = :descricao");
		Query query = em.createQuery(jpql.toString(), Permissao.class);
		query.setParameter("descricao", descricao);
		try {		
			Boolean autoriza = (Boolean) query.getSingleResult();
			return autoriza;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public List<Permissao> procurarPorTipoUsuario(TipoUsuario tipo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select obj from Permissao obj inner join obj.tipoUsuarios obj2 where obj2.id = :id");
		TypedQuery<Permissao> query = em.createQuery(jpql.toString(), Permissao.class);
		query.setParameter("id", tipo.getId());
		try {		
			List<Permissao> listObj = query.getResultList();
			return listObj;
		} catch (NoResultException e) {
			return new ArrayList<>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Permissao procurarPorPermissaoRetornandoPermissao(String descricao) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select obj from Permissao obj where obj.descricao = :descricao");
		TypedQuery<Permissao> query = em.createQuery(jpql.toString(), Permissao.class);
		query.setParameter("descricao", descricao);
		try {					
			return  query.getSingleResult();
		} catch (NoResultException e) {
			return new Permissao();
		} catch (Exception e) {
			return null;
		}
	}

}
