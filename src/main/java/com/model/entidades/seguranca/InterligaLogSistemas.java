package com.model.entidades.seguranca;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Interliga_Log_Sistemas")
public class InterligaLogSistemas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9149152842245274504L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="data_Horario_acesso" , nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHorarioAcesso;
	
	@Column(name="data_Horario_saida" , nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHorariosaida;
	
	@OneToMany(mappedBy="interligaLogSistemas", targetEntity=LogSistema.class)
	private List<LogSistema> logSistema;

	/**
	 * @param id
	 * @param controleAcesso
	 * @param dataHorarioAcesso
	 * @param dataHorariosaida
	 * @param logSistema
	 */
	public InterligaLogSistemas(Long id,
			Date dataHorarioAcesso, Date dataHorariosaida) {
		super();
		this.id = id;
		this.dataHorarioAcesso = dataHorarioAcesso;
		this.dataHorariosaida = dataHorariosaida;
	}

	/**
	 * 
	 */
	public InterligaLogSistemas() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LogSistema> getLogSistema() {
		return logSistema;
	}

	public void setLogSistema(List<LogSistema> logSistema) {
		this.logSistema = logSistema;
	}
	
	public Date getDataHorarioAcesso() {
		return dataHorarioAcesso;
	}

	public void setDataHorarioAcesso(Date dataHorarioAcesso) {
		this.dataHorarioAcesso = dataHorarioAcesso;
	}

	public Date getDataHorariosaida() {
		return dataHorariosaida;
	}

	public void setDataHorariosaida(Date dataHorariosaida) {
		this.dataHorariosaida = dataHorariosaida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((logSistema == null) ? 0 : logSistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterligaLogSistemas other = (InterligaLogSistemas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logSistema == null) {
			if (other.logSistema != null)
				return false;
		} else if (!logSistema.equals(other.logSistema))
			return false;
		return true;
	}
}
