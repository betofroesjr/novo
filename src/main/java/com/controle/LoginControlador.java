package com.controle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.model.entidades.base.Usuario;
import com.model.entidades.seguranca.InterligaLogSistemas;
import com.model.entidades.seguranca.LogSistema;
import com.model.servico.IAutenticadorService;
import com.model.servico.IInterligaLogSistemasService;
import com.model.servico.ILogSistemaService;
import com.model.servico.IUsuarioService;
import com.util.SpringContainer;
import com.web.Navegacao;

@Component("loginControlador")
@Scope("session")
public class LoginControlador implements AuthenticationProvider, Serializable{
	
	private static final long serialVersionUID = -5865836528539551668L;
	private Usuario usuario;
	private LogSistema log;
	private InterligaLogSistemas ligaLog;
	public String PAGINA_CORRENTE = "";
	public String INDEX = "";
	private String url;
	private int contadorInatividade = 90;	//TODO
	
	@Autowired private IAutenticadorService autenticador;
	@Autowired private IUsuarioService usuarioServico;
	@Autowired private ILogSistemaService logSistemaService;
	@Autowired private IInterligaLogSistemasService interligacaoLogSistema; 
	
	/**
	 * @author José Humberto
	 * @date 13/05/14
	 * @return pagina do modelo de acordo com login
	 */

	public String logar(){
		try {
			/*para criptografia
			 *  getUsuario().setSenha(getUsuario().getSenha());*/
			System.out.println("Logando...");/*  Verifica conexão para buscar usuário*/
			this.usuario = autenticador.autentica(getUsuario().getLogin(), getUsuario().getSenha());	
			
			/*Verifica se retornou algum usuário*/
			if(this.usuario == null || this.usuario.getLogin() == null || this.usuario.getLogin().equals("") || this.usuario.getLogin().length() < 3){
				setarMensagemInfo("Login ou senha inválidos.");
				return null;
			} else {
				
				this.ligaLog = null;//Limpa o interliga Log
				
				//funcionando 
				this.usuario.setInterligaLogSistemas(getLigaLog());
				
			}
			
			if (usuario != null && usuario.getStatus() == 0){
								
				if(ContextoUtil.getObjetoSessao("usuario") == null || this.url == null || this.url.equals("")){
					logarSessao(usuario);				
					// JOGA USUARIO NO CONTEXTO DO SPRING SECURITY
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getLogin(), null, usuario.getAuthorities());
					token.setDetails(usuario);
					SecurityContextHolder.createEmptyContext();
					SecurityContextHolder.getContext().setAuthentication(token);
					this.INDEX = "/pagRestrita/principal.jsf" + "?faces-redirect=true";
				} else {
					this.INDEX = this.url.substring(22);//Tira a palavra '/controletotalmecanica'
				}						
				
				return INDEX;
				
			} 
					
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}

	public String sair() {
		try {
			logoutSessao();
		} catch (Exception e) {
			setarMensagemErro(e.getMessage());
		}
		return "/pagPublica/login.jsf?faces-redirect=true";
	}

	/**
	 *
	 */
	public String limpar() {
		try {
			setUsuario(new Usuario());
		} catch (Exception e) {
			setarMensagemErro(e.getMessage());
		}
		return PAGINA_CORRENTE;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private void logarSessao(Usuario usuario) {
		try {			
			controleInterligacaoLog(this.ligaLog);		
			ContextoUtil.getSessao().setAttribute("usuario", usuario);
					
			controleAcesso(this.usuario);			
			
		} catch (Exception e) {
			setarMensagemErro(e.getMessage());
		}
	}

	private String logoutSessao() {
		try {
			ligaLog.setDataHorariosaida(new Date(System.currentTimeMillis()));
			controleInterligacaoLog(this.ligaLog);	
			
			ContextoUtil.getSessao().removeAttribute("usuario");
			ContextoUtil.getSessao().invalidate();
			SecurityContextHolder.clearContext();
			/*autenticador.refresh(this.usuario);*/
			autenticador.desanexar(this.usuario);
			usuarioServico.limparDadosJPA();// no momento está limpando dados do cache da JPA			
			limpar();
			ContextoUtil.refresh();
		} catch (Exception e) {
			setarMensagemErro(e.getMessage());
		}
		return "/pagPublica/login.jsf?faces-redirect=true";
	}

	public Usuario getUsuarioSessao() {
		return (Usuario) ContextoUtil.getSessao().getAttribute("usuario");
	}	
	
	public InterligaLogSistemas controleAcesso(Usuario user){
		
		if(user != null){
						
			return controleLogSistema(user, null, user.getId());
		}
		return null;
	}	
	
	public boolean isLogado() {
		Usuario usuario = null;
		try {
			usuario = getUsuarioSessao();
		} catch (Exception e) {
			setarMensagemErro(e.getMessage());
		}
		return usuario != null;
	}	

	private void setarMensagemErro(String message) {
		FacesContext.getCurrentInstance().addMessage("ERROR",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
	}

	protected void setarMensagemInfo(String message) {
		FacesContext.getCurrentInstance().addMessage("INFO",
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
	}

	public static LoginControlador getInstancia() {
		return ((LoginControlador) SpringContainer.getInstancia().getBean(
				"loginControlador"));
	}

	@Override
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	/**
	 * @return o ligaLog
	 */
	public InterligaLogSistemas getLigaLog() {

		this.ligaLog = controleInterligacaoLog(this.ligaLog);

		return ligaLog;
	}

	/**
	 * @param ligaLog o ligaLog a ser configurado
	 */
	public void setLigaLog(InterligaLogSistemas ligaLog) {
		this.ligaLog = ligaLog;
	}
	

	public void inatividade(){
		try {
 			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			
			Long horaDateAtual = System.currentTimeMillis()/1000;
			
			Long ultimoAcesso = session.getLastAccessedTime()/1000;
			
			Long ultimoAcessoResult = horaDateAtual - ultimoAcesso;

			if(ultimoAcessoResult > 90){
				this.url = request.getRequestURI(); 			
				FacesContext.getCurrentInstance().getExternalContext().redirect("/controletotalmecanica"+Navegacao.getLogin());
			} else {
				setContadorInatividade(30);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public InterligaLogSistemas controleLogSistema(Object obj, List<LogSistema> lista, Long idObjeto){
		if(obj != null){
			if(ligaLog == null){
				ligaLog = LoginControlador.getInstancia().getUsuarioSessao().getInterligaLogSistemas();
				if(ligaLog == null){
					ligaLog = new InterligaLogSistemas();
					controleInterligacaoLog(ligaLog);
				}
			}
			log = new LogSistema();
			log.setClasseModificado(obj.getClass().toString());
			log.setInterligaLogSistemas(ligaLog);
			log.setId_Componente_Alterado(idObjeto);
			log.setDataHorarioModificao(new Date(System.currentTimeMillis()));			
			
			if(this.usuario.getTipoUsuario() != null){	
				
				usuarioServico.desanexar(this.usuario);
				usuarioServico.fecharSessaoJPA();
				usuarioServico.limparDadosJPA();
				
				this.usuario.getTipoUsuario().setInterligaLogSistemas(null);
				this.usuario.getTipoUsuario().setPermissao(null);
				this.usuario.getTipoUsuario().setUsuario(null);
				log.setJsonObject(converterObjetoJson(obj));
				this.usuario = usuarioServico.procurarPorId(this.usuario.getId());
			}
			
			logSistemaService.salvar(log);
			
			if(lista == null){
				lista = new ArrayList<>();			
			}
			lista.add(log);
			ligaLog.setLogSistema(lista);						

			controleInterligacaoLog(ligaLog);
			
			return ligaLog;
		}
		return null;
	}
	
	private String converterObjetoJson(Object obj) {
		
		try{
			Gson gson = new Gson();
			String teste = gson.toJson(obj); 
			return teste;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public InterligaLogSistemas controleInterligacaoLog(InterligaLogSistemas editado){
				
		try{
			if(editado == null){
				editado = new InterligaLogSistemas();
			}
			if (editado.getId() == null || editado.getId() == 0) {
				editado.setId(null);
				editado.setDataHorarioAcesso(new Date(System.currentTimeMillis()));
				editado.setLogSistema(new ArrayList<LogSistema>());
				System.out.printf("\n\nEntrou no metodo SALVAR! - LOGSISTEMA");
				interligacaoLogSistema.salvar(editado);
			} else {
				System.out.printf("\n\nEntrou no metodo ALTERAR! - LOGSISTEMA");
				interligacaoLogSistema.alterar(editado);
			}
			ligaLog = editado;			
			return ligaLog;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int getContadorInatividade() {
		return contadorInatividade;
	}

	public void setContadorInatividade(int contadorInatividade) {
		this.contadorInatividade = contadorInatividade;
	}	
}
