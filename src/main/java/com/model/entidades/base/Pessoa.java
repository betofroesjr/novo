package com.model.entidades.base;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.ForeignKey;

import com.model.entidades.seguranca.Auditoria;

@Entity
@Table(name="pessoa")
public class Pessoa extends Auditoria{

	/**
	 * Autor: José Humberto
	 */
	private static final long serialVersionUID = 9099241393650347178L;
	
	private String nome;
	
	@Column(name="documento_identidade")
	private String documentoIdentidade;
	
	private String cpf;
	private String sexo;
	private String email;
	private Date dataNascimento;
		
	@Transient
	@Foo
	private int idade;
	
	@Temporal(TemporalType.DATE)
	@Column(updatable=false)
	private Date dataInclusao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	//TODO Criar logica para data final da pessoa no sistema
	@Temporal(TemporalType.DATE)
	@Column(updatable=false)
	private Date dataFinal;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_tipoPessoa")
	@ForeignKey(name="fk_pessoa_tipopessoa")	
	private TipoPessoa tipoPessoa;
		
	@ManyToMany(mappedBy = "pessoa", targetEntity=Logradouro.class)	
	private List<Logradouro> logradouro;
	
	@OneToMany(mappedBy="pessoa", targetEntity=Telefone.class)
	private List<Telefone> telefone;
	
	@Transient
	@Foo
	private String maskCpf;
	
	public Pessoa() {
		super();
		this.nome = "";
		this.documentoIdentidade = "";
		this.cpf = "";
		this.sexo = "";
		this.email = "";
		this.dataNascimento = null;
		this.idade = 0;
		this.dataInclusao = new Date();
		this.dataAlteracao = new Date();
		this.dataFinal = null;
		this.tipoPessoa = new TipoPessoa();		
		this.logradouro = new ArrayList<>();	
		this.telefone = new ArrayList<>();
	}
	
	public Pessoa(String nome, String documentoIdentidade, String cpf,
			String sexo, String email, Date dataNascimento, int idade,
			Date dataInclusao, Date dataAlteracao, Date dataFinal,
			TipoPessoa tipoPessoa, List<Logradouro> logradouro,
			List<Telefone> telefone) {
		super();
		this.nome = nome;
		this.documentoIdentidade = documentoIdentidade;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.dataFinal = dataFinal;
		this.tipoPessoa = tipoPessoa;
		this.logradouro = logradouro;
		this.telefone = telefone;		
	}

	public List<Logradouro> getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(List<Logradouro> logradouro) {
		this.logradouro = logradouro;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumentoIdentidade() {
		return documentoIdentidade;
	}
	public void setDocumentoIdentidade(String documentoIdentidade) {
		this.documentoIdentidade = documentoIdentidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	@XmlTransient
	public int getIdade() {
		 // Data de hoje.  
        GregorianCalendar agora = new GregorianCalendar();  
        int ano = 0, mes = 0, dia = 0;  
          
        // Data do nascimento.  
        GregorianCalendar nascimento = new GregorianCalendar();  
        int anoNasc = 0, mesNasc = 0, diaNasc = 0;  
  
        // Idade.  
        this.idade = 0;  
          
        if(this.getDataNascimento() != null){  
            nascimento.setTime(this.getDataNascimento());  
              
            ano = agora.get(Calendar.YEAR);  
            mes = agora.get(Calendar.MONTH) + 1;  
            dia = agora.get(Calendar.DAY_OF_MONTH);  
              
            anoNasc = nascimento.get(Calendar.YEAR);  
            mesNasc = nascimento.get(Calendar.MONTH) + 1;  
            diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);  
              
            idade = ano - anoNasc;  
              
            // Calculando diferencas de mes e dia.  
            if(mes < mesNasc) {  
                idade--;  
            } else {  
                if((mes == mesNasc) && (dia < diaNasc)) {  
                    idade--;  
                }  
            }  
              
            // Ultimo teste, idade "negativa".  
            if(idade < 0) {  
                idade = 0;  
            }  
              
        }  
  
        return (idade);       
	}	

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	@Transient
	public String getMaskCpf() {
		if(this.cpf != null && this.cpf.equals("")){
			return "";
		} else {
			if(this.cpf.length() >= 11){
				return cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9);				
			} else {
				return "";
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result
				+ ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result
				+ ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime
				* result
				+ ((documentoIdentidade == null) ? 0 : documentoIdentidade
						.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idade;
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((maskCpf == null) ? 0 : maskCpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result
				+ ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataAlteracao == null) {
			if (other.dataAlteracao != null)
				return false;
		} else if (!dataAlteracao.equals(other.dataAlteracao))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		if (dataInclusao == null) {
			if (other.dataInclusao != null)
				return false;
		} else if (!dataInclusao.equals(other.dataInclusao))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (documentoIdentidade == null) {
			if (other.documentoIdentidade != null)
				return false;
		} else if (!documentoIdentidade.equals(other.documentoIdentidade))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idade != other.idade)
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (maskCpf == null) {
			if (other.maskCpf != null)
				return false;
		} else if (!maskCpf.equals(other.maskCpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoPessoa == null) {
			if (other.tipoPessoa != null)
				return false;
		} else if (!tipoPessoa.equals(other.tipoPessoa))
			return false;
		return true;
	}	
}
