package com.model.persistence;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Estado;

@Repository
public class EstadoDao extends GenericDAOImpl<Estado, Long> implements IEstadoDao {

	@Override
	public void salvar(Estado obj) {
		em.persist(obj);
	}

	@Override
	public Estado procurarPorNome(String nomeEstado) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Estado obj WHERE obj.nomeEstado = :nomeEstado");
		Query query = em.createQuery(jpql.toString(), Estado.class);
		query.setParameter("nomeEstado", nomeEstado);
		try {
			Estado obj = (Estado) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Estado procurarPorCidade(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Estado obj INNER JOIN obj.cidade obj2 WHERE obj2.id = :id");
		TypedQuery<Estado> query = em.createQuery(jpql.toString(), Estado.class);
		query.setParameter("id", id);
		try {
			Estado obj = (Estado) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	
}
