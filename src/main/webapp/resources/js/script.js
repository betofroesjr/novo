/**
 * 
 */
//coloco isto para não ter conflito com outras versões do jquery ( no caso do proprio componente) vc tb pode abrir a lib e atualizar o jquery lá mesmo ...
var $j = jQuery.noConflict(); 
//para minhas funções
function mascara(){
		$j(".valor").maskMoney({		
			decimal:",", 
			thousands:".", 
			allowZero:true
		});  //ai todo componente que eu colocar class='valor' vai pegar esta mascara
};
	



