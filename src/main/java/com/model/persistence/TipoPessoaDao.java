package com.model.persistence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.TipoPessoa;

@Repository
public class TipoPessoaDao extends GenericDAOImpl<TipoPessoa, Long> implements ITipoPessoaDao {

	@Override
	public void salvar(TipoPessoa obj) {
		em.persist(obj);
	}

	@Override
	public TipoPessoa buscarPorDescricao(String descricao) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM TipoPessoa obj WHERE obj.descricao = :descricao");
		Query query = em.createQuery(jpql.toString(), TipoPessoa.class);
		query.setParameter("descricao", descricao);
		try {
			TipoPessoa obj = (TipoPessoa) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}	
	
}
