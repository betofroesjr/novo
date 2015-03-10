package com.controle.auditoria;

import java.util.ArrayList;

import com.model.entidades.base.Fornecedor;

public class TesteLogXml {

	public static void main(String[] args) {
		LogSistemaControle sis = new LogSistemaControle();
		Fornecedor projeto = new Fornecedor();
		
		projeto.setId(1l);
		projeto.setDescricao("qualqer");
		projeto.setStatus(0);
		
		System.out.println("TEste" + sis.marshal(projeto, "TipoProjetoAtendimentoJSONCONVERT"));
		
	}
}
