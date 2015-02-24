package com.model.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Pessoa;
import com.model.entidades.base.Telefone;

@Repository
public class TelefoneDao extends GenericDAOImpl<Telefone, Long> implements ITelefoneDao {

	@Override
	public void salvar(Telefone obj) {
		em.persist(obj);
	}

	@Override
	public List<Telefone> listarPorPessoa(Pessoa pessoa) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Telefone obj INNER JOIN obj.pessoa objInt WHERE objInt.id = :id");
		TypedQuery<Telefone> query = em.createQuery(jpql.toString(), Telefone.class);
		query.setParameter("id", pessoa.getId());
		try {
			List<Telefone> listObj = query.getResultList();			
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
