package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.051-0300")
@StaticMetamodel(Logradouro.class)
public class Logradouro_ extends Auditoria_ {
	public static volatile SingularAttribute<Logradouro, String> nomeLogradouro;
	public static volatile SingularAttribute<Logradouro, String> numeroLote;
	public static volatile SingularAttribute<Logradouro, String> quadra;
	public static volatile SingularAttribute<Logradouro, String> lote;
	public static volatile SingularAttribute<Logradouro, String> complemento;
	public static volatile SingularAttribute<Logradouro, String> cep;
	public static volatile SingularAttribute<Logradouro, Bairro> bairro;
	public static volatile ListAttribute<Logradouro, Pessoa> pessoa;
	public static volatile SingularAttribute<Logradouro, Boolean> enderecoAtual;
}
