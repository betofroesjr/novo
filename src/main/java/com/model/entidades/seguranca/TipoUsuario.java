package com.model.entidades.seguranca;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.model.entidades.base.Foo;
import com.model.entidades.base.Usuario;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3946388211671475921L;
	
	@ManyToMany(targetEntity=Permissao.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_permissao", referencedColumnName="id", nullable=false)
	private List<Permissao> permissao;
	
	@OneToMany(mappedBy="tipoUsuario", fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@Foo
	private List<Usuario> usuario; 
	
	private String descricao;		
	
	public TipoUsuario() {
		super();
	}
	
	public TipoUsuario(List<Permissao> permissao, String descricao) {
		super();
		this.permissao = permissao;
		this.descricao = descricao;
	}

	public List<Permissao> getPermissao() {
		return permissao;
	}
	public void setPermissao(List<Permissao> permissao) {
		this.permissao = permissao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}	
}
