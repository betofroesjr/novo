package com.model.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;

@Repository
public class TipoUsuarioDao extends GenericDAOImpl<TipoUsuario, Long> implements ITipoUsuarioDao {

	@Override
	public void salvar(TipoUsuario entidade) {
		em.persist(entidade);
	}

	@Override
	public List<Permissao> carregarListaCompleta(TipoUsuario editado) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM Permissao obj INNER JOIN obj.tipoUsuarios obj2 WHERE obj2.id = :id");
		TypedQuery<Permissao> query = em.createQuery(jpql.toString(), Permissao.class);
		query.setParameter("id", editado.getId());
		try {
			List<Permissao> listObj = query.getResultList();			
			return listObj;
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TipoUsuario procurarPorDescricao(String string) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM TipoUsuario obj WHERE obj.descricao = :string");
		TypedQuery<TipoUsuario> query = em.createQuery(jpql.toString(), TipoUsuario.class);
		query.setParameter("string", string);
		try {
			return query.getSingleResult();
		} catch (NoResultException e){
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}
