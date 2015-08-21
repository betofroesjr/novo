package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.047-0300")
@StaticMetamodel(Estado.class)
public class Estado_ extends Auditoria_ {
	public static volatile SingularAttribute<Estado, String> nomeEstado;
	public static volatile SingularAttribute<Estado, String> siglaEstado;
	public static volatile SingularAttribute<Estado, Integer> menorCep;
	public static volatile SingularAttribute<Estado, Integer> maiorCep;
	public static volatile ListAttribute<Estado, Cidade> cidade;
}
