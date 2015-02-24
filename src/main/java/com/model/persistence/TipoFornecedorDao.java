package com.model.persistence;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.model.entidades.base.TipoFornecedor;

@Repository
public class TipoFornecedorDao extends GenericDAOImpl<TipoFornecedor, Long> implements ITipoFornecedorDao{
	@Override
	public void salvar(TipoFornecedor obj) {
		em.persist(obj);
	}

	@Override
	public TipoFornecedor procurarPorDescricao(String descricao) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT obj FROM TipoFornecedor obj WHERE obj.descricao = :descricao");
		Query query = em.createQuery(jpql.toString(), TipoFornecedor.class);
		query.setParameter("descricao", descricao);
		try {
			TipoFornecedor obj = (TipoFornecedor) query.getSingleResult();			
			return obj;
		}catch (NoResultException e){
			return null;
		}catch (Exception e) {
			return null;
		}
	}
}