package com.model.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDAOImpl<E, ID extends Serializable> implements GenericDAO<E, ID> {

	private  Class<E> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(){
		this.classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@PersistenceContext (type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public Class<E> getClasse() {
		return this.classe;
	}
	
	public void alterar(E entidade) {
		em.merge(entidade);

	}

	public void remover(E entidade){
		//Quando objeto está na transação 
		em.remove(entidade);
	}
	
	public void remover(E entidade, Long id){
		//Quando tiver o risco da tranasação ter finalizado - em teste
		em.remove(em.getReference(entidade.getClass(), id));
	}

	public E buscarPorId(ID id) {
		E entidade = em.find(classe, id);
		return entidade;
	}
	
	public void refresh(E entidade){
		em.refresh(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<E> buscarTodos() {
		List<E> lista = em.createQuery("select o from "+ classe.getSimpleName() + " o").getResultList(); 
		return lista;
	}
	
	public void detach(E entidade){
		em.detach(entidade);
	}
	
	public void limpar(E entidade){
		/*em.flush();*/
		em.clear();
	}
	
	public void executarScprit(String string){
		Query q = em.createNativeQuery(string);
		q.executeUpdate();	
	}
	
	public Connection getConexao(){
		return ((SessionImpl) (em.getDelegate())).connection();
	}
	
	public void fecharSessaoJPA(){
		em.close();
	}
}