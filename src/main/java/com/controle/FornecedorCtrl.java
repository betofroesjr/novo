package com.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.controle.auditoria.LogSistemaControle;
import com.model.entidades.base.Fornecedor;
import com.model.entidades.base.Usuario;
import com.model.servico.IFornecedorService;
import com.relatorio.GenericoRel;
import com.util.CentralMensagens;
import com.web.Navegacao;

@Controller
@Scope("view")
public class FornecedorCtrl extends ControladorGenericoCtrl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5306783905831195223L;
	private Fornecedor 			editado;
	private List<Fornecedor> 	lista;
	
	@Autowired private IFornecedorService 	serv;	
	@Autowired private LogSistemaControle	logSistemaControle;
	@Autowired private GenericoRel 			rel;
	
	public FornecedorCtrl() {
		if(ContextoUtil.getObjetoSessao(Navegacao.getNomeObjetoSessaoFornecedor()) != null){
			setEditado((Fornecedor) ContextoUtil.getObjetoSessao(Navegacao.getNomeObjetoSessaoFornecedor()));			
		}
	}
	
	public void novo() {
		limpar();
		getLista();
	}
	
	public String resetPagina() {
		ContextoUtil.setObjetoSessao(Navegacao.getNomeObjetoSessaoFornecedor(), null);
		limpar();
		return "";
	}
	
	private boolean validacaoRemover() {
	
		return false;
	}
	
	public boolean validaAlterarStatus() {
		
		return false;
	}
	
	public boolean validacao() {

		return false;
	}
	
	public String salvar() {

		Usuario usuario = LoginControlador.getInstancia().getUsuarioSessao();
		this.editado.setInterligaLogSistemas(usuario.getInterligaLogSistemas());
					
		if (this.validacao() || validaAlterarStatus()) {
			return null;
		} else {
			try {
				if (editado.getId() == null || editado.getId() == 0) {
					editado.setId(null);
					this.serv.salvar(editado);
					lista.add(this.editado);
					CentralMensagens.setarMensagemInclusaoSucesso();					
				} else {
					this.serv.alterar(editado);
					CentralMensagens.setarMensagemAlteracaoSucesso();
				}	
				logSistemaControle.setUsuario(usuario);
				logSistemaControle.controleLogSistema(this.editado, usuario.getInterligaLogSistemas().getLogSistema(), this.editado.getId());
			} catch (Exception e) {
				CentralMensagens.setarMensagemErroInclusao();				
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public String remover() {
		if (validacaoRemover()) {
			return null;
		} else {
			try {
				this.serv.remover(editado);
				CentralMensagens.setarMensagemExclusaoSucesso();
				novo();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public void alterar() {
		setValorBotao(getValorBotaoAlterar());
		setPermissaoExcluir(true);			
	}
	
	public void limpar() {
		
		ContextoUtil.setObjetoSessao(Navegacao.getNomeObjetoSessaoFornecedor(), null);
		editado = null;
		valorBotao = getValorBotaoIncluir();
		this.lista = null;
		setPermissaoExcluir(false);		
		ContextoUtil.refresh();
	}
	
	public Fornecedor verificarExistencia(Fornecedor obj) {

		novo();
		this.editado = (serv.buscarPorObjeto(obj)) == null ? obj : serv.buscarPorObjeto(obj);
		salvar();
		return this.editado;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public String acaoGeraRelatorio() {
		try {
			List<Map> itens = new ArrayList<>();
			if (this.lista == null) {
				getLista();
				if (this.lista == null) {
					CentralMensagens.setarMensagemErroGerarRelatorio();					
					return null;
				}
			}
			for (Fornecedor iteracao : this.lista) {
				Map<String, Object> item = new HashMap<String, Object>();
				/*
				 * item.put("id", iteracao.getId()); item.put("descricao",
				 * iteracao.getProjeto_descricao()); item.put("status",
				 * iteracao.getProjeto_status());
				 */

				itens.add(item);
			}
			rel.imprimir("rel" + Fornecedor.class.getSimpleName(), itens);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void onRowSelect(SelectEvent event) {
		if(this.editado == null || this.editado.getId() == null || this.editado.getId() == 0 
				|| this.editado.getId() != ((Fornecedor) event.getObject()).getId()){
			
			this.editado = (Fornecedor) event.getObject();
			
			ContextoUtil.setObjetoSessao(Navegacao.getNomeObjetoSessaoFornecedor(), this.editado);
			
			setPermissaoExcluir(true);
			setValorBotao(getValorBotaoAlterar());
			FacesMessage msg = new FacesMessage("Agregado selecionado", this.editado.getDescricao());
			FacesContext.getCurrentInstance().addMessage(null, msg);     
			
		/*} else {
			
			this.editado = (Agregado) event.getObject();
			this.atendimentoSocial.setPessoaAtendimento(null);
			ContextoUtil.setObjetoSessao(Navegacao.getNomeObjetoSessaoAtendimentoSocial(), this.atendimentoSocial);
			gravarListapermissoesAbasSessao("aba1", true);
			
			FacesMessage msg = new FacesMessage("Foi retirada a seleção do Agregado", this.editado.getPessoa().getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.editado = new Agregado();
			
			RequestContext context = RequestContext.getCurrentInstance();
		    context.execute("tableAgregados.unselectAllRows()");
		    
		    setPermissaoExcluir(false);
			setValorBotao(getValorBotaoIncluir());*/
		}
	}
	
	public Fornecedor getEditado() {
		if(this.editado == null){
			this.editado = new Fornecedor();
		} else {
			ContextoUtil.setObjetoSessao(Navegacao.getNomeObjetoSessaoFornecedor(), editado);
		}
		return editado;
	}
	
	public void setEditado(Fornecedor editado) {
		this.editado = editado;
	}
	
	public List<Fornecedor> getLista() {
		if(this.lista == null){
			this.lista = serv.lista();
		}
		return lista;
	}
	
	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}	
}
