package com.model.entidades.seguranca;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.model.entidades.base.Foo;

@MappedSuperclass
public abstract class Auditoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530178266579953257L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_Interliga_Log_Sistemas")
	@Foo
	private InterligaLogSistemas interligaLogSistemas;
	
	public Auditoria() {
		this.id = null;
		this.interligaLogSistemas = null;
	}

	public Auditoria(Long id, InterligaLogSistemas interligaLogSistemas) {
		super();
		this.id = id;
		this.interligaLogSistemas = interligaLogSistemas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InterligaLogSistemas getInterligaLogSistemas() {
		return interligaLogSistemas;
	}

	public void setInterligaLogSistemas(InterligaLogSistemas interligaLogSistemas) {
		this.interligaLogSistemas = interligaLogSistemas;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditoria other = (Auditoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Auditoria [id=" + id + "]";
	}
	
	
}
