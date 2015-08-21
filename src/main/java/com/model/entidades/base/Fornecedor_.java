package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.049-0300")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ extends Auditoria_ {
	public static volatile SingularAttribute<Fornecedor, String> descricao;
	public static volatile SingularAttribute<Fornecedor, String> cnpj;
	public static volatile SingularAttribute<Fornecedor, Integer> status;
	public static volatile SingularAttribute<Fornecedor, TipoFornecedor> dados_Tipo_Fornecedor;
}
