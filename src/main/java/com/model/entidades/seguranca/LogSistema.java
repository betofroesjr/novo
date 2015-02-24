package com.model.entidades.seguranca;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="log_sistema") 
public class LogSistema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4546559473665083686L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="data_Horario_modificao" , nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHorarioModificao;	
	
	@Column(name="classe_Modificado" , nullable=false)
	private String classeModificado;	
	
	private Long id_Componente_Alterado;
	
	@ManyToOne
	@JoinColumn(name="id_Interliga_Log_Sistemas")
	private InterligaLogSistemas interligaLogSistemas;

	@Column(name="jsonObject", columnDefinition="VARCHAR(4000)")
	private String jsonObject;
		
	public LogSistema() {
		super();
	}

	/**
	 * @param id
	 * @param dataHorarioModificao
	 * @param classeModificado
	 * @param id_Componente_Alterado
	 * @param interligaLogSistemas
	 * @param jsonObject
	 * @param controleAlteracaoInclusao
	 */
	public LogSistema(Long id, Date dataHorarioModificao,
			String classeModificado, Long id_Componente_Alterado,
			InterligaLogSistemas interligaLogSistemas, String jsonObject) {
		super();
		this.id = id;
		this.dataHorarioModificao = dataHorarioModificao;
		this.classeModificado = classeModificado;
		this.id_Componente_Alterado = id_Componente_Alterado;
		this.interligaLogSistemas = interligaLogSistemas;
		this.jsonObject = jsonObject;
	}

	public String getClasseModificado() {
		return classeModificado;
	}
	public void setClasseModificado(String classeModificado) {
		this.classeModificado = classeModificado;
	}
	public InterligaLogSistemas getInterligaLogSistemas() {
		return interligaLogSistemas;
	}
	public void setInterligaLogSistemas(InterligaLogSistemas interligaLogSistemas) {
		this.interligaLogSistemas = interligaLogSistemas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataHorarioModificao() {
		return dataHorarioModificao;
	}

	public void setDataHorarioModificao(Date dataHorarioModificao) {
		this.dataHorarioModificao = dataHorarioModificao;
	}

	public Long getId_Componente_Alterado() {
		return id_Componente_Alterado;
	}

	public void setId_Componente_Alterado(Long id_Componente_Alterado) {
		this.id_Componente_Alterado = id_Componente_Alterado;
	}

	public String getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}	
}
