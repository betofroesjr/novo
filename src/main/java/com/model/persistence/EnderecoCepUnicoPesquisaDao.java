package com.model.persistence;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.EnderecoCepUnicoPesquisa;

@Repository
public class EnderecoCepUnicoPesquisaDao extends GenericDAOImpl<EnderecoCepUnicoPesquisa, Long> implements IEnderecoCepUnicoPesquisaDao {

	@Override
	public void salvar(EnderecoCepUnicoPesquisa entidade) {
		em.persist(entidade);
	}

	@Override
	public EnderecoCepUnicoPesquisa buscarPorCep(String cep) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM EnderecoCepUnicoPesquisa obj INNER JOIN obj.cidade obj3 INNER JOIN obj3.estado obj4 WHERE obj.CEP = :cep");
		TypedQuery<EnderecoCepUnicoPesquisa> query = em.createQuery(jpql.toString(), EnderecoCepUnicoPesquisa.class);
		query.setParameter("cep", cep);
		try {
			EnderecoCepUnicoPesquisa obj = query.getSingleResult();
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
