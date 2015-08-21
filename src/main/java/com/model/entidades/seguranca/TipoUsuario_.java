package com.model.entidades.seguranca;

import com.model.entidades.base.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.112-0300")
@StaticMetamodel(TipoUsuario.class)
public class TipoUsuario_ extends Auditoria_ {
	public static volatile ListAttribute<TipoUsuario, Permissao> permissao;
	public static volatile ListAttribute<TipoUsuario, Usuario> usuario;
	public static volatile SingularAttribute<TipoUsuario, String> descricao;
}
