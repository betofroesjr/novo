$(document).ready(function(){
	var mousex = 0;
	var mousey = 0;
	
	$("html").mousemove(function(mouse){
		mousex = mouse.pageX;
		mousey = mouse.pageY;		
		if(mousex < 20 && mousey > 0){
			$(".ui-collapsible").css(
					"display","block"
			);	
			$(".ui-layout-center").css({
					"width":"100%",
					"left":"325px"
			});	
		} else if(mousex < 500){
			
		} else {
			$(".ui-collapsible").css(
					"display","none"
			);
			$(".ui-layout-center").css({
				"width":"120%",
				"left":"0px"
			});	
		};
	});
});