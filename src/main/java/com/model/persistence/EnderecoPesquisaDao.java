package com.model.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.EnderecoPesquisa;

@Repository
public class EnderecoPesquisaDao extends GenericDAOImpl<EnderecoPesquisa, Long> implements IEnderecoPesquisaDao {

	@Override
	public void salvar(EnderecoPesquisa entidade) {
		em.persist(entidade);
	}

	@Override
	public EnderecoPesquisa buscarPorCep(String cep) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM EnderecoPesquisa obj INNER JOIN obj.bairro obj2 INNER JOIN obj2.cidade obj3 INNER JOIN obj3.estado obj4 WHERE obj.CEP = :cep");
		TypedQuery<EnderecoPesquisa> query = em.createQuery(jpql.toString(), EnderecoPesquisa.class);
		query.setParameter("cep", cep);
		try {
			EnderecoPesquisa obj = query.getSingleResult();
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<String> listarTiposLogradouros() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT DISTINCT obj.tp_logradouro FROM EnderecoPesquisa obj");
		TypedQuery<String> query = em.createQuery(jpql.toString(), String.class);
		try {
			List<String> listObj = query.getResultList();			
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<String> listarNomesLogradouros(EnderecoPesquisa obj) {			
		//TODO homologar
		String bairro = "";
		String tp_logradouro = "";
		String codicional = " WHERE ";
		String separador = " AND ";
		
		if(obj != null && obj.getBairro() != null && obj.getBairro().getId() != null  && obj.getBairro().getId() != 0){	
			bairro = codicional + " obj.bairro.id = :id_bairro ";
		}
		if(obj != null && obj.getTp_logradouro() != null && !obj.getTp_logradouro().equals("")){
			if(!bairro.equals("")){				
				tp_logradouro = separador + " obj.tp_logradouro = :tp_logradouro ";
			} else {
				tp_logradouro = codicional + " obj.tp_logradouro = :tp_logradouro ";
			}
		}

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT DISTINCT obj.logradouro FROM EnderecoPesquisa obj ");
		if(!bairro.equals("")){
			jpql.append(bairro);
		}
		if(!tp_logradouro.equals("")){
			jpql.append(tp_logradouro);
		}
		TypedQuery<String> query = em.createQuery(jpql.toString(), String.class);

		if(!bairro.equals("")){
			query.setParameter("id_bairro", obj.getBairro().getId());
		}
		if(!tp_logradouro.equals("")){
			query.setParameter("tp_logradouro", obj.getTp_logradouro());
		}
		
		try {
			List<String> listObj = query.getResultList();			
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}
