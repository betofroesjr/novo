package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import com.model.entidades.seguranca.TipoUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.097-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ extends Auditoria_ {
	public static volatile SingularAttribute<Usuario, String> nomeCompleto;
	public static volatile SingularAttribute<Usuario, String> login;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, Integer> status;
	public static volatile SingularAttribute<Usuario, String> cpf;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> telefone;
	public static volatile SingularAttribute<Usuario, Boolean> tipoAdm;
	public static volatile SingularAttribute<Usuario, Boolean> tipoDesenv;
	public static volatile SingularAttribute<Usuario, Boolean> tipoUser;
	public static volatile SingularAttribute<Usuario, TipoUsuario> tipoUsuario;
}
