package com.model.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;

@Repository
public class CidadeDao extends GenericDAOImpl<Cidade, Long> implements ICidadeDao{

	@Override
	public void salvar(Cidade obj) {
		em.persist(obj);
	}

	@Override
	public Cidade procurarPorNome(String nomeCidade) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Cidade obj WHERE obj.nomeCidade = :nomeCidade");
		Query query = em.createQuery(jpql.toString(), Cidade.class);
		query.setParameter("nomeCidade", nomeCidade);
		try {
			Cidade obj = (Cidade) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Cidade> procurarPorCidade(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Cidade obj INNER JOIN obj.estado obj2 WHERE obj2.id = :id");
		TypedQuery<Cidade> query = em.createQuery(jpql.toString(), Cidade.class);
		query.setParameter("id", id);
		try {
			List<Cidade> listObj = query.getResultList();
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Bairro> listarPorCidade(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Bairro obj INNER JOIN obj.cidade obj2 WHERE obj2.id = :id");
		TypedQuery<Bairro> query = em.createQuery(jpql.toString(), Bairro.class);
		query.setParameter("id", id);
		try {
			List<Bairro> listObj = query.getResultList();
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
