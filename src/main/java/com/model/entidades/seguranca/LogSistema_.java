package com.model.entidades.seguranca;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.106-0300")
@StaticMetamodel(LogSistema.class)
public class LogSistema_ {
	public static volatile SingularAttribute<LogSistema, Long> id;
	public static volatile SingularAttribute<LogSistema, Date> dataHorarioModificao;
	public static volatile SingularAttribute<LogSistema, String> classeModificado;
	public static volatile SingularAttribute<LogSistema, Long> id_Componente_Alterado;
	public static volatile SingularAttribute<LogSistema, InterligaLogSistemas> interligaLogSistemas;
	public static volatile SingularAttribute<LogSistema, String> jsonObject;
}
