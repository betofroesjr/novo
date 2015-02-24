/**
 * não consegui fazer funcionar depois vou estudar mais sobre javascript com primefaces e jsf
 */
 function changeValue(obj, msg, disable) {      
        alert('iniciando');  
          
        obj = document.getElementById(obj);  
        alert(obj.value);  
        obj.textContent = msg;  
        alert(obj.value);  
  
        if(disable){    
            alert('entrou no if');  
            obj.setAttribute("class",obj.getAttribute("class")+" ui-state-disabled");     
            obj.setAttribute("disable","disable");     
            obj.setAttribute("aria-disabled",disable);     
        }else{    
            alert('entrou no else');  
            obj.setAttribute("class",obj.getAttribute("class").replace(" ui-state-disabled", ""));     
            obj.removeAttribute("disable");     
            obj.setAttribute("aria-disabled",disable);     
        }    
        alert('saiu');  
 }    