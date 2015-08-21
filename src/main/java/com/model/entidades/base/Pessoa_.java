package com.model.entidades.base;

import com.model.entidades.seguranca.Auditoria_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.074-0300")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ extends Auditoria_ {
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, String> documentoIdentidade;
	public static volatile SingularAttribute<Pessoa, String> cpf;
	public static volatile SingularAttribute<Pessoa, String> sexo;
	public static volatile SingularAttribute<Pessoa, String> email;
	public static volatile SingularAttribute<Pessoa, Date> dataNascimento;
	public static volatile SingularAttribute<Pessoa, Date> dataInclusao;
	public static volatile SingularAttribute<Pessoa, Date> dataAlteracao;
	public static volatile SingularAttribute<Pessoa, Date> dataFinal;
	public static volatile SingularAttribute<Pessoa, TipoPessoa> tipoPessoa;
	public static volatile ListAttribute<Pessoa, Logradouro> logradouro;
	public static volatile ListAttribute<Pessoa, Telefone> telefone;
}
