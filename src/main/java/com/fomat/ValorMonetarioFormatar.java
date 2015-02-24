package com.fomat;

import java.text.NumberFormat;

public class ValorMonetarioFormatar {
	
	public String formatValorMonetario(String valorMonetario){
		try{
			NumberFormat tipoMonetario = NumberFormat.getCurrencyInstance();
			Double valorMonetarioDouble = Double.parseDouble(valorMonetario);			
			return tipoMonetario.format(valorMonetarioDouble);
		}catch (Exception e) {
			System.out.println("Nao foi possivel efetuar a conversao deste valor" + valorMonetario + "Erro: ");
			e.printStackTrace();
			return "";
		}
	}

}
