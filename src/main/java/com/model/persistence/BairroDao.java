package com.model.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;

@Repository
public class BairroDao extends GenericDAOImpl<Bairro, Long> implements IBairroDao {

	@Override
	public void salvar(Bairro obj) {
		em.persist(obj);
	}

	@Override
	public Bairro procurarPorNome(String nomeBairro) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Bairro obj WHERE obj.nomeBairro = :nomeBairro");
		Query query = em.createQuery(jpql.toString(), Bairro.class);
		query.setParameter("nomeBairro", nomeBairro);
		try {
			Bairro obj = (Bairro) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Cidade procurarPorBairro(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Cidade obj INNER JOIN obj.bairros obj2 WHERE obj2.id = :id");
		TypedQuery<Cidade> query = em.createQuery(jpql.toString(), Cidade.class);
		query.setParameter("id", id);
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
	public List<Bairro> listarPorEstado(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Bairro obj INNER JOIN obj.cidade obj2 INNER JOIN obj2.estado obj3 WHERE obj3.id = :id");
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
