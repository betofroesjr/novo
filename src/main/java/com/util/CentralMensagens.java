package com.util;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class CentralMensagens {

	public static final String INFO = "INFO";
	public static final String ERROR = "ERROR";
	public static final String WARN = "WARN";
	public static final String FATAL = "FATAL";
	public String AVISO_INCLUSAO;
	public String AVISO_EXCLUSAO;
	public String AVISO_ALTERACAO;

	public static void setarMensagemErro(Exception e) {
		e.printStackTrace();
		setarMensagemErro(e.getMessage());
	}
	
	private static void addMensagem(Severity severity, String titulo, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage(severity, titulo, msg));
	}

	public static void setarMensagemErro(String message) {
		addMensagem(FacesMessage.SEVERITY_ERROR, ERROR, message);
	}

	public static void setarMensagemInfo(String message) {
		addMensagem(FacesMessage.SEVERITY_INFO, INFO, message);
	}

	public static void setarMensagemAviso(String message) {
		addMensagem(FacesMessage.SEVERITY_WARN, WARN, message);
	}

	public static void setarMensagemFatal(String message) {
		addMensagem(FacesMessage.SEVERITY_FATAL, FATAL, message);
	}

	public static void setarMensagemErroMapeada(String chave, Object... parametros) {
		setarMensagemErro(Mensagem.get(chave, parametros));
	}

	public static void setarMensagemInfoMapeada(String chave, Object... parametros) {
		setarMensagemInfo(Mensagem.get(chave, parametros));
	}

	public static void setarMensagemAvisoMapeada(String chave, Object... parametros) {
		setarMensagemAviso(Mensagem.get(chave, parametros));
	}

	public static void setarMensagemFatalMapeada(String chave, Object... parametros) {
		setarMensagemFatal(Mensagem.get(chave, parametros));
	}

	public static void setarMensagemErroRelatorio() {
		addMensagem(FacesMessage.SEVERITY_ERROR, ERROR,	Mensagem.get("erro.relatorio", new Date().getTime()));
	}

	/**************************************/
	/** Mensagens de Sucesso Padronizadas */
	/**************************************/

	public static void setarMensagemInclusaoSucesso() {
		setarMensagemInfo(Mensagem.get("controle.inclusao.sucesso"));
	}

	public static void setarMensagemAlteracaoSucesso() {
		setarMensagemInfo(Mensagem.get("controle.alteracao.sucesso"));
	}

	public static void setarMensagemExclusaoSucesso() {
		setarMensagemInfo(Mensagem.get("controle.exclusao.sucesso"));
	}
	
	public static void setarMensagemErroInclusao(){
		setarMensagemInfo(Mensagem.get("controle.erro.salvar"));
	}

	public static void setarMensagemErroGerarRelatorio(){
		setarMensagemInfo(Mensagem.get("controle.erro.gerarRelatorio"));
	}
	
	public static void setarMensagemErroDadosPessoa(){
		setarMensagemInfo(Mensagem.get("controle.erro.dadosPessoa"));
	}
}
