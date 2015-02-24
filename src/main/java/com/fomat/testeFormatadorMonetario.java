package com.fomat;


public class testeFormatadorMonetario {

	/*Metodo para testar se formatador monetario esta funcionando corretamente
	 * Teste efetuado com sucesso.
	 */
	public static void main(String[] args) {
		String valor = "10.01";
		ValorMonetarioFormatar vm = new ValorMonetarioFormatar();
		valor = vm.formatValorMonetario(valor);
		System.out.println(valor);
	}

}
