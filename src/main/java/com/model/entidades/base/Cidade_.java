package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.038-0300")
@StaticMetamodel(Cidade.class)
public class Cidade_ extends Auditoria_ {
	public static volatile SingularAttribute<Cidade, String> nomeCidade;
	public static volatile SingularAttribute<Cidade, Estado> estado;
	public static volatile ListAttribute<Cidade, Bairro> bairros;
}
