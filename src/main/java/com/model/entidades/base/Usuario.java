package com.model.entidades.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.model.entidades.Role;
import com.model.entidades.seguranca.Auditoria;
import com.model.entidades.seguranca.TipoUsuario;


@Entity
@Table(name="usuario")
public class Usuario extends Auditoria {
	


	/**Autor: José Humberto
	 * 
	 */
	
	private static final long serialVersionUID = 5187909194416550533L;
	
	@Column(name="nome_completo")
	private String nomeCompleto;
	
	@Column(name="login", unique=true)
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="status")
	private Integer status;
	
	//TODO Não coloquei como único pois o sistema legado onde busca informações não permitiu pois têm valores errados e duplicados
	@Column(name="cpf")//, unique=true
	private String cpf;
	
	@Column(name="email")
	private String email;	
	
	@Column(name="telefone")
	private String telefone;
	
	//Para teste login depois mudar estilo
	private boolean tipoAdm;
	private boolean tipoDesenv;
	private boolean tipoUser;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario", referencedColumnName="id")	
	private TipoUsuario tipoUsuario;
		
	@Transient	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> list = new ArrayList<Role>();
		
		if(this.tipoAdm){
			Role role = new Role();
			role.setDescricao("ROLE_ADMIN");
			list.add(role);
		}
		if(this.tipoDesenv){
			Role role = new Role();
			role.setDescricao("ROLE_DESENV");
			list.add(role);
		}
		if(this.tipoUser){
			Role role = new Role();
			role.setDescricao("ROLE_USER");
			list.add(role);
		}		
		return list;
	}
	
	public Usuario() {
		super();		
		this.tipoUser = true;		
	}		

	public Usuario(String nomeCompleto, String login, String senha,
			Integer status, String cpf, String email, boolean tipoAdm,
			boolean tipoUser) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.cpf = cpf;
		this.email = email;
		this.tipoAdm = tipoAdm;
		this.tipoUser = tipoUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public boolean isTipoAdm() {
		return tipoAdm;
	}

	public void setTipoAdm(boolean tipoAdm) {
		this.tipoAdm = tipoAdm;
	}

	public boolean isTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(boolean tipoUser) {
		this.tipoUser = tipoUser;
	}

	/**
	 * @return o telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone o telefone a ser configurado
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * @return o tipoDesenv
	 */
	public boolean isTipoDesenv() {
		return tipoDesenv;
	}

	/**
	 * @param tipoDesenv o tipoDesenv a ser configurado
	 */
	public void setTipoDesenv(boolean tipoDesenv) {
		this.tipoDesenv = tipoDesenv;
	}
	
	

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/* (não-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}	
}
