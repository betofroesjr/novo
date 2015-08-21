package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:18.479-0300")
@StaticMetamodel(Bairro.class)
public class Bairro_ extends Auditoria_ {
	public static volatile SingularAttribute<Bairro, String> nomeBairro;
	public static volatile SingularAttribute<Bairro, Cidade> cidade;
}
