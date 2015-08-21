package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.079-0300")
@StaticMetamodel(Telefone.class)
public class Telefone_ extends Auditoria_ {
	public static volatile SingularAttribute<Telefone, Pessoa> pessoa;
	public static volatile SingularAttribute<Telefone, String> tipoTelefone;
	public static volatile SingularAttribute<Telefone, String> numero;
	public static volatile SingularAttribute<Telefone, String> ramal;
}
