package com.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.entidades.base.Usuario;
import com.model.entidades.seguranca.Permissao;
import com.model.entidades.seguranca.TipoUsuario;
import com.model.servico.IPermissaoService;

@Controller
@Scope("session")
public class PermissaoCtrl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6936832458218978096L;
	private Usuario usuarioSessao;
	private Boolean validarUsuarioAdmin = false;;
	
	private Permissao permissao;
	private List<Permissao> listaPermissoes;
	private IPermissaoService serv;	
	//Todas as permissões das telas 
	private Boolean cadastro = false;
	private Boolean cadusuario = false;
	private Boolean cadtipousuario = false;	
	private Boolean caddepartamento = false;	
	private Boolean alterpermissoes = false;
	private Boolean servicosbase = false;
	private Boolean novoprojeto = false;
	private Boolean novoobjetivo = false;
	private Boolean novameta = false;
	private Boolean novotipoatendimento = false;	
	private Boolean tabelaDesconto = false;
	private Boolean cadServicoAutomotivo = false;
	private Boolean consAtendimentoSocial = false;
	private Boolean novoatendimentosocial = false;
	private Boolean atendimentoSocial = false;
	private Boolean cadInstituicaoEnsino = false;
	private Boolean cadTipoCurso = false;
	private Boolean cadCurso = false;
	private Boolean cadBolsaEstudantil = false;
	private Boolean menuatendimentosocial = false;
	private Boolean consSolicitacaoAtendimentoSocial = false;
	private Boolean cadEvento = false;
	private Boolean cadLocalEvento = false;
	private Boolean cadEncontrosCongressos = false;
	private Boolean cadTipoMaterialCautela = false;
	private Boolean cadMaterialCautela = false;
	private Boolean cadCautela = false;
	private Boolean menueducacional = false;
	private Boolean menuassistenciaespiritual = false;
	private Boolean menuassistenciafuneraria = false;
	private Boolean cadTipoFornecedor = false;
	private Boolean cadFornecedor = false;
	private Boolean cadMateriaisServicos = false;
	private Boolean cadAssistenciaFuneraria = false;
	private Boolean cadBanco = false;
	private Boolean cadTipoConta = false;
	private Boolean cadDadosBancarios = false;
	private Boolean cadMateriaisEncontrosCongressos = false;
	private Boolean projetoApoioEspiritual = false;
	private Boolean manutencaoAtendimentoSocial = false;
	private Boolean instituicoesEnsinoCursos = false;
	private Boolean eventosEncontrosCongressos = false;
	private Boolean cautela = false;
	private Boolean fornecedoresMateriaisServicos = false;
	private Boolean bancosTiposContas = false;
	private Boolean controleFrota = false;
	private Boolean cadViaturas = false;
	private Boolean cadServicoViaturas = false;
	private Boolean cadEncaminhamentoManutencaoViaturas = false;
	private Boolean consultaHistoricoAtendimento = false;
	private Boolean relIndenizacoes = false;
	private Boolean relEmissaoGuiaFT = false;
	private Boolean relatorio = false;
	private Boolean relAnual = false;
	private Boolean expedicaoGuias = false;
	private Boolean consGuia = false;
	private Boolean todasGuias = false;
	private Boolean consultaTodosAtendimentoPorUsuario = false;
	private Boolean fardamento = false;
	private Boolean relAjudaCusto = false;
	private Boolean manutencaoBeneficiario = false;
	private Boolean cadBeneficiario = false;
	private Boolean relExtratoBenef = false;
	private Boolean consFinanceira = false;

	//Habilitar auto esconder do menu lateral
	private Boolean menuatendimentosocialAutoEsconder = false;
	
	@Autowired
	public PermissaoCtrl(IPermissaoService serv) {
		this.serv = serv; 
	}
	
	public Boolean getValidarUsuarioAdmin() {
		if(this.usuarioSessao != null && this.usuarioSessao.getLogin().equals("admin")){
			this.validarUsuarioAdmin = true;
		}
		return validarUsuarioAdmin;
	}

	public void setValidarUsuarioAdmin(Boolean validarUsuarioAdmin) {
		this.validarUsuarioAdmin = validarUsuarioAdmin;
	}

	public Permissao getPermissao() {
		if(this.permissao == null){
			this.permissao = new Permissao();
		}
		return permissao;
	}
	
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Permissao> getListaPermissoes(){
		if(listaPermissoes == null || listaPermissoes.size() == 0){							
			this.usuarioSessao = LoginControlador.getInstancia().getUsuarioSessao();
			if(usuarioSessao != null){
				TipoUsuario tipo = usuarioSessao.getTipoUsuario();
				if (tipo == null) {
					listaPermissoes = new ArrayList<>();
				} 
				/*Problema de LazyInit testando 
				 * else if(tipo.getPermissao() != null && tipo.getPermissao().size() > 0){
					listaPermissoes = tipo.getPermissao();
				} */
				else {
					listaPermissoes = serv.procurarPorTipoUsuario(tipo);
				}
				return listaPermissoes;
			} else {
				listaPermissoes = new ArrayList<>();
			}
		}
		return listaPermissoes;
	}

	public Boolean verificaPermissao(String campo){
		Boolean verifificarAutorizacao = false;
		getListaPermissoes();		
		for (int i = 0; i < listaPermissoes.size();i++) {			
			if(listaPermissoes.get(i).getDescricao().equals(campo)){
				verifificarAutorizacao = listaPermissoes.get(i).getAutorizacao();				
				return verifificarAutorizacao;
			}
		}
		return verifificarAutorizacao;
	}
	
	public void setListar(List<Permissao> listar) {
		listaPermissoes = listar;
	}

	

	public void setCadastro(Boolean cadastro) {
		this.cadastro = cadastro;
	}

	public IPermissaoService getServ() {
		return serv;
	}

	public void setServ(IPermissaoService serv) {
		this.serv = serv;
	}

	public Boolean getCadusuario() {
		this.cadusuario = this.verificaPermissao("cadusuario");
		return cadusuario;
	}

	public void setCadusuario(Boolean cadusuario) {
		this.cadusuario = cadusuario;
	}
	
	public Boolean getCaddepartamento() {
		this.caddepartamento = this.verificaPermissao("caddepartamento");
		return caddepartamento;
	}

	public void setCaddepartamento(Boolean caddepartamento) {
		this.caddepartamento = caddepartamento;
	}

	public Boolean getAlterpermissoes() {
		this.alterpermissoes = this.verificaPermissao("alterpermissoes");
		return alterpermissoes;
	}

	public void setAlterpermissoes(Boolean alterpermissoes) {
		this.alterpermissoes = alterpermissoes;
	}

	public void setServicosbase(Boolean servicosbase) {
		this.servicosbase = servicosbase;
	}

	public Boolean getNovoprojeto() {
		this.novoprojeto = this.verificaPermissao("novoprojeto");
		return novoprojeto;
	}

	public void setNovoprojeto(Boolean novoprojeto) {
		this.novoprojeto = novoprojeto;
	}

	public Boolean getNovoobjetivo() {
		this.novoobjetivo = this.verificaPermissao("novoobjetivo");
		return novoobjetivo;
	}

	public void setNovoobjetivo(Boolean novoobjetivo) {
		this.novoobjetivo = novoobjetivo;
	}

	public Boolean getNovameta() {
		this.novameta = this.verificaPermissao("novameta");
		return novameta;
	}

	public void setNovameta(Boolean novameta) {
		this.novameta = novameta;
	}

	public Boolean getNovotipoatendimento() {
		this.novotipoatendimento = this.verificaPermissao("novotipoatendimento");
		return novotipoatendimento;
	}

	public void setNovotipoatendimento(Boolean novotipoatendimento) {
		this.novotipoatendimento = novotipoatendimento;
	}	

	public Boolean getNovoatendimentosocial() {
		this.novoatendimentosocial = this.verificaPermissao("novoatendimentosocial");
		return novoatendimentosocial;
	}

	public void setNovoatendimentosocial(Boolean novoatendimentosocial) {
		this.novoatendimentosocial = novoatendimentosocial;
	}

	public Boolean getCadtipousuario() {
		this.cadtipousuario = this.verificaPermissao("cadtipo_usuario");
		return cadtipousuario;
	}

	public void setCadtipousuario(Boolean cadtipousuario) {
		this.cadtipousuario = cadtipousuario;
	}

	public Boolean getTabelaDesconto() {
		this.tabelaDesconto = this.verificaPermissao("tabelaDesconto");
		return tabelaDesconto;
	}

	public void setTabelaDesconto(Boolean tabelaDesconto) {
		this.tabelaDesconto = tabelaDesconto;
	}

	public Boolean getCadServicoAutomotivo() {
		this.cadServicoAutomotivo = this.verificaPermissao("cadServicoAutomotivo");
		return cadServicoAutomotivo;
	}

	public void setCadServicoAutomotivo(Boolean cadServicoAutomotivo) {
		this.cadServicoAutomotivo = cadServicoAutomotivo;
	}
	
	public Boolean getCadInstituicaoEnsino() {
		this.cadInstituicaoEnsino = this.verificaPermissao("cadInstituicaoEnsino");
		return cadInstituicaoEnsino;
	}

	public void setCadInstituicaoEnsino(Boolean cadInstituicaoEnsino) {
		this.cadInstituicaoEnsino = cadInstituicaoEnsino;
	}
	
	public Usuario getUsuarioSessao() {
		if(this.usuarioSessao == null){
			this.usuarioSessao = new Usuario();
		}
		return usuarioSessao;
	}

	public void setUsuarioSessao(Usuario usuarioSessao) {
		this.usuarioSessao = usuarioSessao;
	}

	public Boolean getAtendimentoSocial() {
		this.atendimentoSocial = this.verificaPermissao("atendimentosocial");
		return atendimentoSocial;
	}

	public void setAtendimentoSocial(Boolean atendimentoSocial) {
		this.atendimentoSocial = atendimentoSocial;
	}

	public Boolean getCadTipoCurso() {
		this.cadTipoCurso = this.verificaPermissao("cadTipoCurso");
		return cadTipoCurso;
	}

	public void setCadTipoCurso(Boolean cadTipoCurso) {
		this.cadTipoCurso = cadTipoCurso;
	}

	public Boolean getCadCurso() {
		this.cadCurso = this.verificaPermissao("cadCurso");
		return cadCurso;
	}

	public void setCadCurso(Boolean cadCurso) {
		this.cadCurso = cadCurso;
	}
	
	public Boolean getCadBolsaEstudantil() {
		this.cadBolsaEstudantil = this.verificaPermissao("cadBolsaEstudantil");
		return cadBolsaEstudantil;
	}

	public void setCadBolsaEstudantil(Boolean cadBolsaEstudantil) {
		this.cadBolsaEstudantil = cadBolsaEstudantil;
	}
	
	public Boolean getCadEvento() {
		this.cadEvento = this.verificaPermissao("cadEvento");
		return cadEvento;
	}

	public void setCadEvento(Boolean cadEvento) {
		this.cadEvento = cadEvento;
	}
	
	public Boolean getCadLocalEvento() {
		this.cadLocalEvento = this.verificaPermissao("cadLocalEvento");
		return cadLocalEvento;
	}

	public void setCadLocalEvento(Boolean cadLocalEvento) {
		this.cadLocalEvento = cadLocalEvento;
	}
	
	public Boolean getCadEncontrosCongressos() {
		this.cadEncontrosCongressos = this.verificaPermissao("cadEncontrosCongressos");
		return cadEncontrosCongressos;
	}

	public void setCadEncontrosCongressos(Boolean cadEncontrosCongressos) {
		this.cadEncontrosCongressos = cadEncontrosCongressos;
	}

	/**
	 * @return o consAtendimentoSocial
	 */
	public Boolean getConsAtendimentoSocial() {
		this.consAtendimentoSocial = this.verificaPermissao("consAtendimentosocial");
		return consAtendimentoSocial;
	}
	
	/**
	 * @return o consSolicitacaoAtendimentoSocial
	 */
	public Boolean getConsSolicitacaoAtendimentoSocial() {
		this.consSolicitacaoAtendimentoSocial = this.verificaPermissao("consSolicitacaoAtendimentoSocial");
		return consSolicitacaoAtendimentoSocial;
	}

	/**
	 * @param consSolicitacaoAtendimentoSocial o consSolicitacaoAtendimentoSocial a ser configurado
	 */
	public void setConsSolicitacaoAtendimentoSocial(
			Boolean consSolicitacaoAtendimentoSocial) {
		this.consSolicitacaoAtendimentoSocial = consSolicitacaoAtendimentoSocial;
	}

	/**
	 * @param consAtendimentoSocial o consAtendimentoSocial a ser configurado
	 */
	public void setConsAtendimentoSocial(Boolean consAtendimentoSocial) {
		this.consAtendimentoSocial = consAtendimentoSocial;
	}

	public Boolean getCadastro() {
		getCadusuario();
		getCadtipousuario();
		getCaddepartamento();
		getAlterpermissoes();
		if(cadusuario || cadtipousuario || caddepartamento || alterpermissoes){
			this. cadastro = true;		
		}
		return cadastro;
	}
	

	public void setProjetoApoioEspiritual(Boolean projetoApoioEspiritual) {
		this.projetoApoioEspiritual = projetoApoioEspiritual;
	}

	/**
	 * @param menutendimentosocial o menutendimentosocial a ser configurado
	 */
	public void setMenuatendimentosocial(Boolean menuatendimentosocial) {
		this.menuatendimentosocial = menuatendimentosocial;
	}

	/**
	 * @return o menuatendimentosocialAutoEsconder
	 */
	public Boolean getMenuatendimentosocialAutoEsconder() {
		return menuatendimentosocialAutoEsconder;
	}

	/**
	 * @param menuatendimentosocialAutoEsconder o menuatendimentosocialAutoEsconder a ser configurado
	 */
	public void setMenuatendimentosocialAutoEsconder(Boolean menuatendimentosocialAutoEsconder) {
		this.menuatendimentosocialAutoEsconder = menuatendimentosocialAutoEsconder;
	}

	public Boolean getCadTipoMaterialCautela() {
		this.cadTipoMaterialCautela = this.verificaPermissao("cadTipoMaterialCautela");
		return cadTipoMaterialCautela;
	}

	public void setCadTipoMaterialCautela(Boolean cadTipoMaterialCautela) {
		this.cadTipoMaterialCautela = cadTipoMaterialCautela;
	}

	public Boolean getCadMaterialCautela() {
		this.cadMaterialCautela = this.verificaPermissao("cadMaterialCautela");
		return cadMaterialCautela;
	}

	public void setCadMaterialCautela(Boolean cadMaterialCautela) {
		this.cadMaterialCautela = cadMaterialCautela;
	}

	public Boolean getCadCautela() {
		this.cadCautela = this.verificaPermissao("cadCautela");
		return cadCautela;
	}

	public void setCadCautela(Boolean cadCautela) {
		this.cadCautela = cadCautela;
	}

	public Boolean getMenuassistenciaespiritual() {
		this.menuassistenciaespiritual = this.verificaPermissao("menuassistenciaespiritual");
		return menuassistenciaespiritual;
	}

	public void setMenuassistenciaespiritual(Boolean menuassistenciaespiritual) {
		this.menuassistenciaespiritual = menuassistenciaespiritual;
	}

	public Boolean getMenueducacional() {
		this.menueducacional = this.verificaPermissao("menueducacional");
		return menueducacional;
	}

	public void setMenueducacional(Boolean menueducacional) {
		this.menueducacional = menueducacional;
	}

	public Boolean getMenuassistenciafuneraria() {
		this.menuassistenciafuneraria = this.verificaPermissao("menuassistenciafuneraria");
		return menuassistenciafuneraria;
	}

	public void setMenuassistenciafuneraria(Boolean menuassistenciafuneraria) {
		this.menuassistenciafuneraria = menuassistenciafuneraria;
	}

	public Boolean getCadTipoFornecedor() {
		this.cadTipoFornecedor = this.verificaPermissao("cadTipoFornecedor");
		return cadTipoFornecedor;
	}

	public void setCadTipoFornecedor(Boolean cadTipoFornecedor) {
		this.cadTipoFornecedor = cadTipoFornecedor;
	}

	public Boolean getCadFornecedor() {
		this.cadFornecedor = this.verificaPermissao("cadFornecedor");
		return cadFornecedor;
	}

	public void setCadFornecedor(Boolean cadFornecedor) {
		this.cadFornecedor = cadFornecedor;
	}

	public Boolean getCadMateriaisServicos() {
		this.cadMateriaisServicos = this.verificaPermissao("cadMateriaisServicos");
		return cadMateriaisServicos;
	}

	public void setCadMateriaisServicos(Boolean cadMateriaisServicos) {
		this.cadMateriaisServicos = cadMateriaisServicos;
	}

	public Boolean getCadAssistenciaFuneraria() {
		this.cadAssistenciaFuneraria = this.verificaPermissao("cadAssistenciaFuneraria");
		return cadAssistenciaFuneraria;
	}

	public void setCadAssistenciaFuneraria(Boolean cadAssistenciaFuneraria) {
		this.cadAssistenciaFuneraria = cadAssistenciaFuneraria;
	}

	public Boolean getCadBanco() {
		this.cadBanco = this.verificaPermissao("cadBanco");
		return cadBanco;
	}

	public void setCadBanco(Boolean cadBanco) {
		this.cadBanco = cadBanco;
	}

	public Boolean getCadTipoConta() {
		this.cadTipoConta = this.verificaPermissao("cadTipoConta");		
		return cadTipoConta;
	}

	public void setCadTipoConta(Boolean cadTipoConta) {
		this.cadTipoConta = cadTipoConta;
	}

	public Boolean getCadDadosBancarios() {
		this.cadDadosBancarios = this.verificaPermissao("cadDadosBancarios");	
		return cadDadosBancarios;
	}

	public void setCadDadosBancarios(Boolean cadDadosBancarios) {
		this.cadDadosBancarios = cadDadosBancarios;
	}

	public Boolean getCadMateriaisEncontrosCongressos() {
		this.cadMateriaisEncontrosCongressos = this.verificaPermissao("cadMateriaisEncontrosCongressos");
		return cadMateriaisEncontrosCongressos;
	}

	public void setCadMateriaisEncontrosCongressos(
			Boolean cadMateriaisEncontrosCongressos) {
		this.cadMateriaisEncontrosCongressos = cadMateriaisEncontrosCongressos;
	}
	
	public void setManutencaoAtendimentoSocial(Boolean manutencaoAtendimentoSocial) {
		this.manutencaoAtendimentoSocial = manutencaoAtendimentoSocial;
	}
	

	public void setInstituicoesEnsinoCursos(Boolean instituicoesEnsinoCursos) {
		this.instituicoesEnsinoCursos = instituicoesEnsinoCursos;
	}
	

	public void setEventosEncontrosCongressos(Boolean eventosEncontrosCongressos) {
		this.eventosEncontrosCongressos = eventosEncontrosCongressos;
	}


	public void setCautela(Boolean cautela) {
		this.cautela = cautela;
	}

	public void setFornecedoresMateriaisServicos(Boolean fornecedoresMateriaisServicos) {
		this.fornecedoresMateriaisServicos = fornecedoresMateriaisServicos;
	}

	public void setBancosTiposContas(Boolean bancosTiposContas) {
		this.bancosTiposContas = bancosTiposContas;
	}
	
	public Boolean getCadViaturas() {
		this.cadViaturas = this.verificaPermissao("cadViaturas");
		return cadViaturas;
	}

	public void setCadViaturas(Boolean cadViaturas) {
		this.cadViaturas = cadViaturas;
	}
	
	public Boolean getCadServicoViaturas() {
		this.cadServicoViaturas = this.verificaPermissao("cadServicoViaturas");
		return cadServicoViaturas;
	}

	public void setCadServicoViaturas(Boolean cadServicoViaturas) {
		this.cadServicoViaturas = cadServicoViaturas;
	}
	
	public Boolean getControleFrota() {
		this.controleFrota = this.verificaPermissao("controleFrota");
		return controleFrota;
	}

	public void setControleFrota(Boolean controleFrota) {
		this.controleFrota = controleFrota;
	}
	
	public Boolean getFardamento() {
		this.fardamento = this.verificaPermissao("fardamento");
		return fardamento;
	}

	public void setFardamento(Boolean fardamento) {
		this.fardamento = fardamento;
	}
	
	public Boolean getCadEncaminhamentoManutencaoViaturas() {
		this.cadEncaminhamentoManutencaoViaturas = this.verificaPermissao("cadEncaminhamentoManutencaoViaturas");
		return cadEncaminhamentoManutencaoViaturas;
	}

	public void setCadEncaminhamentoManutencaoViaturas(Boolean cadEncaminhamentoManutencaoViaturas) {
		this.cadEncaminhamentoManutencaoViaturas = cadEncaminhamentoManutencaoViaturas;
	}
	
	public Boolean getServicosbase() {
		getManutencaoAtendimentoSocial();
		getInstituicoesEnsinoCursos();
		getEventosEncontrosCongressos();
		getCautela();
		getFornecedoresMateriaisServicos();
		getBancosTiposContas();
		getManutencaoBeneficiario();
		if(manutencaoAtendimentoSocial || instituicoesEnsinoCursos || eventosEncontrosCongressos || cautela || fornecedoresMateriaisServicos || bancosTiposContas || manutencaoBeneficiario){
			this.servicosbase = true;
		}
		return servicosbase;
	}	
	
	public Boolean getManutencaoBeneficiario() {
		getCadBeneficiario();
		if(cadBeneficiario){
			this.manutencaoBeneficiario = true;
		}
		return manutencaoBeneficiario;
	}
	
	public Boolean getCadBeneficiario() {
//		System.out.println("passei corretamente...");
		this.cadBeneficiario = this.verificaPermissao("cadBeneficiario");
		return cadBeneficiario;
	}

	public void setCadBeneficiario(Boolean cadBeneficiario) {
		this.cadBeneficiario = cadBeneficiario;
	}

	public void setManutencaoBeneficiario(Boolean manutencaoBeneficiario) {
		this.manutencaoBeneficiario = manutencaoBeneficiario;
	}

	public Boolean getManutencaoAtendimentoSocial() {
		getNovoprojeto();
		getNovoobjetivo();
		getNovameta();
		getNovotipoatendimento();
		if(novoprojeto || novoobjetivo || novameta || novotipoatendimento){
			this.manutencaoAtendimentoSocial = true;
		}
		return manutencaoAtendimentoSocial;
	}

	public Boolean getInstituicoesEnsinoCursos() {
		getCadInstituicaoEnsino();
		getCadTipoCurso();
		getCadCurso();
		if(cadInstituicaoEnsino || cadTipoCurso || cadCurso){
			this.instituicoesEnsinoCursos = true;
		}
		return instituicoesEnsinoCursos;
	}
	
	public Boolean getEventosEncontrosCongressos() {
		getCadEvento();
		getCadLocalEvento();
		if(cadEvento || cadLocalEvento){
			this.eventosEncontrosCongressos = true;
		}
		return eventosEncontrosCongressos;
	}

	public Boolean getCautela() {
		getCadTipoMaterialCautela();
		getCadMaterialCautela();
		if(cadTipoMaterialCautela || cadMaterialCautela){
			this.cautela = true;
		}
		return cautela;
	}
	
	public Boolean getFornecedoresMateriaisServicos() {
		getCadTipoFornecedor();
		getCadFornecedor();
		getCadMateriaisServicos();
		if(cadTipoFornecedor || cadFornecedor || cadMateriaisServicos){
			this.fornecedoresMateriaisServicos = true;
		}
		return fornecedoresMateriaisServicos;
	}
	
	public Boolean getBancosTiposContas() {
		getCadBanco();
		getCadTipoConta();
		if(cadBanco || cadTipoConta){
			this.bancosTiposContas = true;
		}
		return bancosTiposContas;
	}

	public void setConsultaHistoricoAtendimento(Boolean consultaHistoricoAtendimento) {
		this.consultaHistoricoAtendimento = consultaHistoricoAtendimento;
	}	
	
	public void setConsultaTodosAtendimentoPorUsuario(
			Boolean consultaTodosAtendimentoPorUsuario) {
		this.consultaTodosAtendimentoPorUsuario = consultaTodosAtendimentoPorUsuario;
	}
	
	/**
	 * @return o menutendimentosocial
	 */
	public Boolean getMenuatendimentosocial() {
		getConsAtendimentoSocial();
		getCadBolsaEstudantil();
		getAtendimentoSocial();
		getConsSolicitacaoAtendimentoSocial();
		getCadCautela();
		getCadDadosBancarios();	
		getConsultaHistoricoAtendimento();
		getExpedicaoGuias();
		getConsGuia();
		getTodasGuias();
		getConsultaTodosAtendimentoPorUsuario();
		if(consultaHistoricoAtendimento || consAtendimentoSocial || cadBolsaEstudantil || atendimentoSocial || consSolicitacaoAtendimentoSocial || cadCautela 
				|| cadDadosBancarios || expedicaoGuias || consGuia || todasGuias){
			this.menuatendimentosocial = true;
		}
		return menuatendimentosocial;
	}
	
	public Boolean getConsultaTodosAtendimentoPorUsuario() {
		this.consultaTodosAtendimentoPorUsuario = this.verificaPermissao("consultaTodosAtendimentoPorUsuario");
		return this.consultaTodosAtendimentoPorUsuario ;
	}

	public Boolean getTodasGuias() {
		this.todasGuias = this.verificaPermissao("todasGuias");
		return todasGuias;
	}	

	public Boolean getExpedicaoGuias() {
		this.expedicaoGuias = this.verificaPermissao("expedicaoGuias");
		return expedicaoGuias;
	}

	public Boolean getConsGuia() {
		this.consGuia = this.verificaPermissao("consGuia");
		return consGuia;
	}

	public Boolean getConsultaHistoricoAtendimento() {
		this.consultaHistoricoAtendimento = this.verificaPermissao("consultaHistoricoAtendimento");
		return consultaHistoricoAtendimento;
	}

	public Boolean getProjetoApoioEspiritual() {
		getCadEncontrosCongressos();
		getCadMateriaisEncontrosCongressos();
		if(cadEncontrosCongressos || cadMateriaisEncontrosCongressos){
			this.projetoApoioEspiritual = true;
		}
		return projetoApoioEspiritual;
	}

	public Boolean getRelIndenizacoes() {
		this.relIndenizacoes = this.verificaPermissao("relIndenizacoes");
		return relIndenizacoes;
	}

	public Boolean getRelEmissaoGuiaFT() {
		this.relEmissaoGuiaFT = this.verificaPermissao("relEmissaoGuiaFT");
		return relEmissaoGuiaFT;
	}

	public Boolean getRelAjudaCusto() {
		this.relAjudaCusto = this.verificaPermissao("relAjudaCusto");
		return relAjudaCusto;
	}

	public Boolean getRelatorio() {
		getRelIndenizacoes();
		getRelEmissaoGuiaFT();
		getRelAjudaCusto();
		getRelExtratoBenef();
		getRelAnual();
		if(this.relIndenizacoes || this.relEmissaoGuiaFT || this.relAjudaCusto || this.relExtratoBenef || this.relAnual){
			this.relatorio = true;
		}
		return relatorio;
	}

	public void setRelAjudaCusto(Boolean relAjudaCusto) {
		this.relAjudaCusto = relAjudaCusto;
	}

	public void setExpedicaoGuias(Boolean expedicaoGuias) {
		this.expedicaoGuias = expedicaoGuias;
	}
	
	public void setRelEmissaoGuiaFT(Boolean relEmissaoGuiaFT) {
		this.relEmissaoGuiaFT = relEmissaoGuiaFT;
	}
	
	public void setRelIndenizacoes(Boolean relIndenizacoes) {
		this.relIndenizacoes = relIndenizacoes;
	}
	
	public void setRelatorio(Boolean relatorio) {
		this.relatorio = relatorio;
	}
	
	public Boolean getRelAnual() {
		this.relAnual = this.verificaPermissao("relAnual");
		return relAnual;
	}	
	public Boolean getRelExtratoBenef() {
		this.relExtratoBenef = this.verificaPermissao("relExtratoBenef");
		return relExtratoBenef;
	}
	public Boolean getFinanceiro(){
		return (getRelExtratoBenef() || getConsFinanceira());
	}
	public Boolean getConsFinanceira() {
		this.consFinanceira = this.verificaPermissao("consFinanceira");
		return consFinanceira;
	}
	public void setRelExtratoBenef(Boolean relExtratoBenef) {
		this.relExtratoBenef = relExtratoBenef;
	}
	public void setRelAnual(Boolean relAnual) {
		this.relAnual = relAnual;
	}
	public void setConsGuia(Boolean consGuia) {
		this.consGuia = consGuia;
	}
	public void setTodasGuias(Boolean todasGuias) {
		this.todasGuias = todasGuias;
	}
	public void setConsFinanceira(Boolean consFinanceira) {
		this.consFinanceira = consFinanceira;
	}		
}