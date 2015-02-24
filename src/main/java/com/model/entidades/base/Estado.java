package com.model.entidades.base;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.model.entidades.seguranca.Auditoria;


@Entity
@Table(name="estado_UF")
public class Estado extends Auditoria {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5925174358110890295L;

	@Column(name="nome_estado")
	private String nomeEstado;
	
	@Column(name="sigla_estado")
	private String siglaEstado;
	
	@Column(name="menor_Cep")
	private Integer menorCep;
	
	@Column(name="maior_Cep")
	private Integer maiorCep;
	
	@OneToMany(mappedBy="estado")
	@Foo
	private List<Cidade> cidade;
	
	public Estado() {
		super();
	}

	/**
	 * @param nomeEstado
	 * @param siglaEstado
	 * @param menorCep
	 * @param maiorCep
	 * @param cidade
	 */
	public Estado(String nomeEstado, String siglaEstado, Integer menorCep, Integer maiorCep) {
		super();
		this.nomeEstado = nomeEstado;
		this.siglaEstado = siglaEstado;
		this.menorCep = menorCep;
		this.maiorCep = maiorCep;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((nomeEstado == null) ? 0 : nomeEstado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (nomeEstado == null) {
			if (other.nomeEstado != null)
				return false;
		} else if (!nomeEstado.equals(other.nomeEstado))
			return false;
		return true;
	}

	/**
	 * @return o siglaEstado
	 */
	public String getSiglaEstado() {
		return siglaEstado;
	}

	/**
	 * @param siglaEstado o siglaEstado a ser configurado
	 */
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	/**
	 * @return o menorCep
	 */
	public Integer getMenorCep() {
		return menorCep;
	}

	/**
	 * @param menorCep o menorCep a ser configurado
	 */
	public void setMenorCep(Integer menorCep) {
		this.menorCep = menorCep;
	}

	/**
	 * @return o maiorCep
	 */
	public Integer getMaiorCep() {
		return maiorCep;
	}

	/**
	 * @param maiorCep o maiorCep a ser configurado
	 */
	public void setMaiorCep(Integer maiorCep) {
		this.maiorCep = maiorCep;
	}

	/**
	 * @return o cidade
	 */
	public List<Cidade> getCidade() {
		return cidade;
	}

	/**
	 * @param cidade o cidade a ser configurado
	 */
	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}
}
