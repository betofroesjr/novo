package com.util.teste;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.servico.IGenericoServico;
import com.web.Navegacao;

@Controller
@Scope("view")
public class InserirInformacoesIniciais {
	
	private String retornoScriptManual;

	@Autowired IGenericoServico serv;
	
	public void salvarScriptGenerico(String string){
		
		try {
			
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			InputStream is = ec.getResourceAsStream(string);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));		
			String sqlCompleto = IOUtils.toString(reader);
			System.out.println(sqlCompleto);
			serv.executarScprit(sqlCompleto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rodarScriptManual(String string){
		
		try {
			
			String sqlCompleto = string;
			System.out.println(sqlCompleto);
			serv.executarScprit(sqlCompleto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void permissoes(){//1
		
		salvarScriptGenerico(Navegacao.getCaminhoArquivoPermissoes());
	}			
	
	public void executarScript(){
		
		rodarScriptManual(getRetornoScriptManual());
		
	}
	
	/**
	 * @return o retornoScriptManual
	 */
	public String getRetornoScriptManual() {
		return retornoScriptManual;
	}

	/**
	 * @param retornoScriptManual o retornoScriptManual a ser configurado
	 */
	public void setRetornoScriptManual(String retornoScriptManual) {
		this.retornoScriptManual = retornoScriptManual;
	}

	public void executarTodosOsScripts(){
		
		try{
			permissoes();//1
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
