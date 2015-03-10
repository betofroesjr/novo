package com.controle.auditoria;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.controle.LoginControlador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.entidades.base.Fornecedor;
import com.model.entidades.base.Usuario;
import com.model.entidades.seguranca.InterligaLogSistemas;
import com.model.entidades.seguranca.LogSistema;
import com.model.servico.IInterligaLogSistemasService;
import com.model.servico.ILogSistemaService;
import com.model.servico.IUsuarioService;

@Component("logSistemaControle")
@Scope("session")
public class LogSistemaControle {

	private Usuario usuario;
	private LogSistema log;
	private InterligaLogSistemas ligaLog;
	
	@Autowired private IUsuarioService usuarioServico;
	@Autowired private ILogSistemaService logSistemaService;
	@Autowired private IInterligaLogSistemasService interligacaoLogSistema;
	
	/**
	 * 
	 */
	public LogSistemaControle() {
		super();
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
			log.setJsonObject(converterObjetoJson(obj));
//			log.setJsonObject(marshal(obj, "AtendimentoSocial"));
					
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
	
	public String converterObjetoJson(Object obj) {
		
		try{
//			Gson gson = new Gson();
			Gson gson = new GsonBuilder()
	        .setExclusionStrategies(new MyExclusionStrategy(Object.class))
	        .serializeNulls()
	        .create();
			
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
	
	public String marshal(Object objeto, String nome){
    	try {
    		StringWriter escritor = new StringWriter();
    		JAXBContext contexto = JAXBContext.newInstance(objeto.getClass());
    		Marshaller marshaller = contexto.createMarshaller();
    		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(new JAXBElement<Fornecedor> (new QName("",nome),     Fornecedor.class,     (Fornecedor) objeto), escritor);
			String testet = escritor.toString(); 
			
			return testet;
		} catch (Exception e) {
			System.out.println("ERRO: CRMAtendimentoExtAcesso.marshal: " + e.toString());
				return null;
		}
    }
}
