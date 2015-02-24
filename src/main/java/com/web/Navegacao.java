package com.web;

public class Navegacao {
	
	private static final String INDEX 			 	         = "/pagAdmin/principal.jsf";
	private static final String LOGIN						 = "/pagPublica/login.jsf";
	private static final String PADRAO_RENDER                = "?faces-redirect=true";
	
	private static final String NOME_OBJETO_SESSAO_LOGRADOURO = "logradouro";
	private static final String NOME_OBJETO_SESSAO_TELEFONE = "telefone";
	
	private static final String CAMINHO_ARQUIVO_PERMISSOES = "/resources/file/permissoes.sql";
	
	/**
	 * @return o index
	 */
	public static String getIndex() {
		return INDEX;
	}
	/**
	 * @return O padrão para acrescentar a tela para ser renderizado
	 */
	public static String getPadraoRender() {
		return PADRAO_RENDER;
	}
	/**
	 * @return o nomeObjetoSessaoLogradouro
	 */
	public static String getNomeObjetoSessaoLogradouro() {
		return NOME_OBJETO_SESSAO_LOGRADOURO;
	}
	/**
	 * @return o caminhoArquivoPermissoes
	 */
	public static String getCaminhoArquivoPermissoes() {
		return CAMINHO_ARQUIVO_PERMISSOES;
	}
	/**
	 * @return o nomeObjetoSessaoTelefone
	 */
	public static String getNomeObjetoSessaoTelefone() {
		return NOME_OBJETO_SESSAO_TELEFONE;
	}
	/**
	 * @return o nomeObjetoSessaoConsSolicitacaoAtendimentoSocial
	 */
	public static String getLogin() {
		return LOGIN;
	}
}