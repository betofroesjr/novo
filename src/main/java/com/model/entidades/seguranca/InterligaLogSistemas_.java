package com.model.entidades.seguranca;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-20T20:47:19.103-0300")
@StaticMetamodel(InterligaLogSistemas.class)
public class InterligaLogSistemas_ {
	public static volatile SingularAttribute<InterligaLogSistemas, Long> id;
	public static volatile SingularAttribute<InterligaLogSistemas, Date> dataHorarioAcesso;
	public static volatile SingularAttribute<InterligaLogSistemas, Date> dataHorariosaida;
	public static volatile ListAttribute<InterligaLogSistemas, LogSistema> logSistema;
}
