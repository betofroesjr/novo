package com.model.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Bairro;
import com.model.entidades.base.Cidade;
import com.model.entidades.base.Logradouro;


@Repository
public class LogradouroDao extends GenericDAOImpl<Logradouro, Long> implements ILogradouroDao {

	@Override
	public void salvar(Logradouro obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Logradouro> logradouroPorPessoa(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Logradouro obj INNER JOIN obj.pessoa obj1 WHERE obj1.id = :id");
		Query query = em.createQuery(jpql.toString(), Logradouro.class);
		query.setParameter("id", id);
		try {
			List<Logradouro> listObj = query.getResultList();			
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	/*Código de pesquisa de endereço completo verificando quais parte do endereço tem dados*/ 
	@Override
	public Logradouro procurarPorObjeto(Logradouro obj) {
		try {
			
		String and = " AND ";
		String nomeLogradouro = obj.getNomeLogradouro();
		String jpqlNomeLogradouro = ((nomeLogradouro != null) && (!nomeLogradouro.equals(""))) ? " obj.nomeLogradouro = :nomeLogradouro " : ""; 
		String jpqlNomeLote = (!jpqlNomeLogradouro.equals("")) ? and : "";
		String jpqlQuadra = (!jpqlNomeLogradouro.equals("") && !jpqlNomeLote.equals("") ) ? and : "";
		String jpqlLote = (!jpqlNomeLogradouro.equals("") && !jpqlNomeLote.equals("") && !jpqlQuadra.equals("") ) ? and : "";
		String jpqlComplemento = (!jpqlNomeLogradouro.equals("") && !jpqlNomeLote.equals("") && !jpqlQuadra.equals("") && !jpqlLote.equals("") ) ? and : "";
		String jpqlCep = (!jpqlNomeLogradouro.equals("") && !jpqlNomeLote.equals("") && !jpqlQuadra.equals("") && !jpqlLote.equals("") && !jpqlComplemento.equals("")) ? and : "";
		String jpqlBairro = (!jpqlNomeLogradouro.equals("") && !jpqlNomeLote.equals("") && !jpqlQuadra.equals("") && !jpqlLote.equals("") && !jpqlComplemento.equals("") && !jpqlCep.equals("")) ? and : "";
		String jpqlCidade = (!jpqlNomeLogradouro.equals("") && !jpqlNomeLote.equals("") && !jpqlQuadra.equals("") && !jpqlLote.equals("") && !jpqlComplemento.equals("") && !jpqlCep.equals("") && !jpqlBairro.equals("")) ? and : "";
		
		String nomeLote = obj.getNumeroLote();
		jpqlNomeLote = ((nomeLote != null) && (!nomeLote.equals(""))) ? jpqlNomeLote + " obj.numeroLote = :numeroLote " : "";
		
		String quadra = obj.getQuadra();
		jpqlQuadra = ((quadra != null) && (!quadra.equals(""))) ? jpqlQuadra + " obj.quadra = :quadra " : "";
		
		String lote = obj.getLote();
		jpqlLote = ((lote != null) && (!lote.equals(""))) ? jpqlLote + " obj.lote = :lote " : "";
		
		String complemento = obj.getComplemento();
		jpqlComplemento = ((complemento != null) && (!complemento.equals(""))) ? jpqlComplemento+" obj.complemento = :complemento " : "";
		
		String cep = obj.getCep();
		jpqlCep = ((cep != null) && (!cep.equals(""))) ? jpqlCep+" obj.cep = :cep " : "";
				
		Bairro bairro = obj.getBairro();
		String nomeBairro = (bairro != null) ? bairro.getNomeBairro() : "";
		jpqlBairro = ((nomeBairro != null) && (!nomeBairro.equals(""))) ? jpqlBairro+" bairro.nomeBairro = :nomeBairro " : "";
		String innerJoinBairro = (bairro != null) ? " INNER JOIN obj.bairro bairro " : "";
		
		Cidade cidade = ((bairro != null) && (bairro.getCidade() != null)) ? obj.getBairro().getCidade() : null; 
		String nomeCidade =  (cidade != null) ? cidade.getNomeCidade() : "";
		jpqlCidade = ((nomeCidade != null) && (!nomeCidade.equals(""))) ? jpqlCidade+" cidade.nomeCidade = :nomeCidade " : "";
		String innerJoinCidade = (cidade != null) ? " INNER JOIN bairro.cidade cidade " : "";
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Logradouro obj "
				+ innerJoinBairro
				+ innerJoinCidade
				+ " WHERE "
				+ jpqlNomeLogradouro
				+ jpqlNomeLote
				+ jpqlQuadra
				+ jpqlLote
				+ jpqlComplemento
				+ jpqlCep
				+ jpqlBairro
				+ jpqlCidade);
		Query query = em.createQuery(jpql.toString(), Logradouro.class);
		if(!jpqlNomeLogradouro.equals("")){query.setParameter("nomeLogradouro", obj.getNomeLogradouro());}
		if(!jpqlNomeLote.equals("")){query.setParameter("numeroLote", obj.getNumeroLote());}
		if(!jpqlQuadra.equals("")){query.setParameter("quadra", obj.getQuadra());}
		if(!jpqlLote.equals("")){query.setParameter("lote", obj.getLote());}
		if(!jpqlComplemento.equals("")){query.setParameter("complemento", obj.getComplemento());}
		if(!jpqlCep.equals("")){query.setParameter("cep", obj.getCep());}
		if(!jpqlBairro.equals("")){query.setParameter("nomeBairro", obj.getBairro().getNomeBairro());}
		if(!jpqlCidade.equals("")){query.setParameter("nomeCidade", obj.getBairro().getCidade().getNomeCidade());}		
		
			obj = (Logradouro) query.getSingleResult();			
			return obj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Logradouro procurarPorEnderecoAtual(Long id) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Logradouro obj INNER JOIN obj.pessoa obj1 WHERE obj1.id = :id and obj.enderecoAtual = true");
		TypedQuery<Logradouro> query = em.createQuery(jpql.toString(), Logradouro.class);
		query.setParameter("id", id);
		try {					
			return query.getSingleResult();
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
