package com.controle.auditoria;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.entidades.base.Fornecedor;

public class TesteGsonJson {
	
	public static void main(String[] args) {
		
//		LogSistemaControle log = new LogSistemaControle();
//		TipoProjetoAtendimento projeto = new TipoProjetoAtendimento();
//		projeto.setId(2l);
//		projeto.setProjeto_descricao("blablablabla");
//		projeto.setProjeto_status(2);
//		
//		String teste = log.converterObjetoJson(projeto);
//		System.out.println(teste);
		
		Gson gson = new GsonBuilder()
        .setExclusionStrategies(new MyExclusionStrategy(Object.class))
        .serializeNulls()
        .create();
		
		Fornecedor projeto = new Fornecedor();
		projeto.setId(2l);
		
	    String json = gson.toJson(projeto);
	    System.out.println(json);
	}
}
