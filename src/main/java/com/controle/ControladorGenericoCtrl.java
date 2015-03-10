package com.controle;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.util.CentralMensagens;
import com.util.Relatorio;

@Component
public abstract class ControladorGenericoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6318023225849815859L;
	protected int currentTab;
	protected String id = "";
	private final String valorBotaoIncluir = "Incluir";
	private final String valorBotaoAlterar = "Alterar";
	protected String valorBotao = valorBotaoIncluir;
	private boolean permissaoExcluir = false;
		
	public int getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(int currentTab) {
		this.currentTab = currentTab;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValorBotao() {
		return valorBotao;
	}

	public void setValorBotao(String valorBotao) {
		this.valorBotao = valorBotao;
	}

	public boolean isPermissaoExcluir() {
		return permissaoExcluir;
	}

	public void setPermissaoExcluir(boolean permissaoExcluir) {
		this.permissaoExcluir = permissaoExcluir;
	}

	public String getValorBotaoIncluir() {
		return valorBotaoIncluir;
	}

	public String getValorBotaoAlterar() {
		return valorBotaoAlterar;
	}

	public void exibirRelatorioSessao(byte[] documento) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().setAttribute(Relatorio.SESSAO, documento);
	}

	public void exibirRelatorio(byte[] documento) {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		try {
			response.getOutputStream().write(documento);

			String nomePagina = FacesContext.getCurrentInstance().getViewRoot().getViewId();

			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename=\"" + nomePagina + ".pdf\"");

			response.getOutputStream().flush();
			response.getOutputStream().close();

			FacesContext.getCurrentInstance().responseComplete();
		} catch (IOException e) {
			CentralMensagens.setarMensagemErro(e.getMessage());
		}
	}
}
