package com.model.entidades.base;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.042-0300")
@StaticMetamodel(EnderecoPesquisa.class)
public class EnderecoPesquisa_ {
	public static volatile SingularAttribute<EnderecoPesquisa, Long> id;
	public static volatile SingularAttribute<EnderecoPesquisa, String> tp_logradouro;
	public static volatile SingularAttribute<EnderecoPesquisa, String> logradouro;
	public static volatile SingularAttribute<EnderecoPesquisa, String> CEP;
	public static volatile SingularAttribute<EnderecoPesquisa, Bairro> bairro;
}
