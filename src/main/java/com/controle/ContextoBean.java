package com.controle;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.entidades.base.Usuario;
import com.model.servico.IUsuarioService;


@Controller
@Scope("session")
public class ContextoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5685845817903308290L;
	private Usuario usuarioLogado = null;
	
	
	@Autowired private	IUsuarioService usuarioserv;
	
	public ContextoBean() {
	}
	
	public Usuario getUsuarioSessao() {
		return (Usuario) ContextoUtil.getSessao().getAttribute("usuario");
	}
	
	public Usuario getUsuarioLogado() {

		try{
			String login = getUsuarioSessao().getLogin();
			if (this.usuarioLogado == null) {
				if (login != null) {				
					this.usuarioLogado = usuarioserv.procurarPorLogin(login);			
				} 
			} 
			return usuarioLogado;
		}catch(Exception e){
			usuarioLogado = new Usuario();
			usuarioLogado.setLogin("Aguardando Login");
			return usuarioLogado;
		}		
	}

	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
			
	/**Se for necessario internacionalizar aplicacao serve para buscar idiomas*/
	 /* public Locale getLocaleUsuario() {
		if (this.localizacao == null) {
			Usuario usuario = this.getUsuarioLogado();
			String idioma = usuario.getIdioma();
			String[] info = idioma.split("_");
			this.localizacao = new Locale(info[0], info[1]);
		}
		return this.localizacao;
	}

	public List<Locale> getIdiomas() {
		FacesContext context = FacesContext.getCurrentInstance();
		Iterator<Locale> locales = context.getApplication()
				.getSupportedLocales();
		this.idiomas = new ArrayList<Locale>();
		while (locales.hasNext()) {
			this.idiomas.add(locales.next());
		}
		return idiomas;
	}

	public void setIdiomaUsuario(String idioma) {
		UsuarioRN usuarioRN = new UsuarioRN();
		this.usuarioLogado = usuarioRN.carregar(this.getUsuarioLogado()
				.getCodigo());
		this.usuarioLogado.setIdioma(idioma);
		usuarioRN.salvar(this.usuarioLogado);

		String[] info = idioma.split("_");
		Locale locale = new Locale(info[0], info[1]);

		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(locale);
	}*/
}
