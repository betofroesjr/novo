package com.model.entidades.base;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.040-0300")
@StaticMetamodel(EnderecoCepUnicoPesquisa.class)
public class EnderecoCepUnicoPesquisa_ {
	public static volatile SingularAttribute<EnderecoCepUnicoPesquisa, Long> id;
	public static volatile SingularAttribute<EnderecoCepUnicoPesquisa, String> CEP;
	public static volatile SingularAttribute<EnderecoCepUnicoPesquisa, Cidade> cidade;
}
