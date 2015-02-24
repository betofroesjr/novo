package com.model.persistence;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.model.entidades.base.Fornecedor;

@Repository
public class FornecedorDao  extends GenericDAOImpl<Fornecedor, Long> implements IFornecedorDao {
	@Override
	public void salvar(Fornecedor obj) {
		em.persist(obj);
	}
	@Override
	public void remover(Fornecedor obj){
		em.remove(em.contains(obj) ? obj : em.merge(obj));
	}
	
	@Override
	public Fornecedor procurarPorDescricao(String descricao) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Fornecedor obj WHERE obj.descricao = :descricao");
		Query query = em.createQuery(jpql.toString(), Fornecedor.class);
		query.setParameter("descricao", descricao);
		try {
			Fornecedor obj = (Fornecedor) query.getSingleResult();			
			return obj;
		}catch (NoResultException e){
			return null;
		}catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listaFornecedoresPorIdTipoFornecedor(Long id){
		try{
			List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
			String jpql = "SELECT obj FROM Fornecedor obj INNER JOIN obj.dados_Tipo_Fornecedor obj2 WHERE obj2.id = :id";
			Query query = em.createQuery(jpql, Fornecedor.class);
			query.setParameter("id", id);
			listaFornecedores = (ArrayList<Fornecedor>) query.getResultList();
			return listaFornecedores;		
		}catch(Exception e){
			return null;
		}
	}
}