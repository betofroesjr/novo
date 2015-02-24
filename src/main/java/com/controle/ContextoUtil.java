package com.controle;

import java.io.Serializable;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ContextoUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1428042202505200385L;
	

	public static ContextoBean getContextoBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);
		ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
		return contextoBean;
	}

	public static void setObjetoSessao(String parametro, Object objeto) {
		// Busca instancia corrente da sessão
		ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
		// Associação da sessão corrente com esta requisição (desta página)
		HttpSession session = (HttpSession) extCon.getSession(true);
		//TODO Verifica se já tem objeto na sessão apaga antes para atualizar - em teste -
		if(getObjetoSessao(parametro) != null){
			deletarObjetoSessao(parametro);			
		} 
		// Setar objeto na sessão corrente
		session.setAttribute(parametro, objeto);
	}

	/**
	 * Pega objeto na sessão corrente, pelo seu respectivo parametro
	 */
	public static Object getObjetoSessao(String parametro) {
		// Busca a instancia da sessão corrente
		ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
		// Associação da sessão corrente com esta requisição (desta página)
		HttpSession session = (HttpSession) extCon.getSession(true);
		// retorno de objeto inserido na sessão corrente
		return (session.getAttribute(parametro));
	}

	/**
	 * Deleta objeto na sessão corrente, pelo seu respectivo parametro
	 */
	public static void deletarObjetoSessao(String parametro) {
		// Busca instancia corrente da sess�o
		ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
		// Associação da sessão corrente com esta requisição (desta página)
		HttpSession session = (HttpSession) extCon.getSession(true);
		// Remove atributo da sess�o corrente
		session.removeAttribute(parametro);
	}
	
	public static FacesContext getInstance(){
		return FacesContext.getCurrentInstance();
	}
	
	public static HttpSession getSessao(){
		FacesContext fc = ContextoUtil.getInstance();
		ExternalContext ec = fc.getExternalContext();
		return (HttpSession) ec.getSession(false);
	}
	
			/**
		* Limpa os dados dos componentes de edi��o e de seus filhos,
		* recursivamente. Checa se o componente � inst�ncia de EditableValueHolder
		* e 'reseta' suas propriedades.
		* <p>
		* Quando este m�todo, por algum motivo, n�o funcionar, parta para ignor�ncia
		* e limpe o componente assim:
		* <p><blockquote><pre>
		* component.getChildren().clear()
		* </pre></blockquote>
		* :-)
		*/	
	public static void cleanSubmittedValues(UIComponent component) {
		if (component instanceof EditableValueHolder) {
			EditableValueHolder evh = (EditableValueHolder) component;
			evh.setSubmittedValue(null);
			evh.setValue(null);
			evh.setLocalValueSet(false);
			evh.setValid(true);
		}
		if (component.getChildCount() > 0) {
			for (UIComponent child : component.getChildren()) {
				cleanSubmittedValues(child);
			}
		}
	}
	
	//Limpa toda �rvore de componentes do JSF 
	public static void refresh(){
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			ViewHandler viewHandler = application.getViewHandler();
			UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());			
			context.setViewRoot(viewRoot);
			context.renderResponse(); //Optional			
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
