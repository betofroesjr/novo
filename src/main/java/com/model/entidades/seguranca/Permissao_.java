package com.model.entidades.seguranca;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.109-0300")
@StaticMetamodel(Permissao.class)
public class Permissao_ extends Auditoria_ {
	public static volatile SingularAttribute<Permissao, String> descricao;
	public static volatile SingularAttribute<Permissao, Boolean> autorizacao;
	public static volatile ListAttribute<Permissao, TipoUsuario> tipoUsuarios;
}
