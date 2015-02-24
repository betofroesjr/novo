package com.model.persistence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Pessoa;

@Repository
public class PessoaDao extends GenericDAOImpl<Pessoa, Long> implements IPessoaDao {

	@Override
	public void salvar(Pessoa obj) {
		em.persist(obj);
	}

	@Override
	public Pessoa procurarPorObjeto(Pessoa obj) {
		StringBuilder jpql = new StringBuilder();
		Query query = null;
		if(obj.getCpf() != null && !obj.getCpf().equals("")){
			jpql.append("SELECT obj FROM Pessoa obj WHERE obj.cpf = :cpf");
			query = em.createQuery(jpql.toString(), Pessoa.class);
			query.setParameter("cpf", obj.getCpf());
		} else if(obj.getDocumentoIdentidade() != null && !obj.getDocumentoIdentidade().equals("")){
			jpql.append("SELECT obj FROM Pessoa obj WHERE obj.documentoIdentidade = :documentoIdentidade");
			query = em.createQuery(jpql.toString(), Pessoa.class);
			query.setParameter("documentoIdentidade", obj.getDocumentoIdentidade());
		} else if (obj.getNome() != null && !obj.getNome().equals("")) {
			jpql.append("SELECT obj FROM Pessoa obj WHERE obj.nome = :nome AND obj.dataNascimento = :dataNascimento");
			query = em.createQuery(jpql.toString(), Pessoa.class);
			query.setParameter("dataNascimento", obj.getDataNascimento());
			query.setParameter("nome", obj.getNome());
		}
		
		try {
			obj = (Pessoa) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}	
}
