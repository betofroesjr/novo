package com.util.teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestarException {

	private static File erros;
	
	public static void main(String[] args) {
		
		try {
			int i = 1000000000;
			List<String> lista = new ArrayList<>();
			String str = lista.get(i);
			System.out.println(str);
		} catch (Exception e) {
			 System.out.println("Nome do erro: " + e.fillInStackTrace());
			 new TestarException().retornaUltimosDezMetodosClassesUtilizados(e.getStackTrace());
			 gravarArquivo(e);
			 System.out.println(e.getStackTrace()[0]);
			 System.out.println(new Throwable().getStackTrace()[0]);
		}		
	}
	
	public static void gravarArquivo(Exception e) {
        try {
        	
            Date data = new Date();
            //Coloque o caminho que voce quiser, de preferencia dentro do projeto
            String caminho = "c:\\temp\\";
            erros = new File(caminho);
            erros.mkdir();

            File destino = new File(erros, "erros.log");            

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString();

            // este true deixa adicionar novas palavras e linhas
            FileWriter fw = new FileWriter(destino, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("["+new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data)+"]");
            bw.newLine();
            bw.write("    "+sw);
            bw.newLine();
            //bw.flush();
            bw.close();

            System.out.println(destino.getAbsolutePath());
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public void retornaUltimosDezMetodosClassesUtilizados(){
		Thread current = Thread.currentThread();  
		StackTraceElement[] stack = current.getStackTrace();
		for(int i = 1; i < (stack.length < 10 ? stack.length : 10)-1;i++){
			System.out.println("-------------------------");
			System.out.println(stack[i].getMethodName());
			System.out.println(stack[i].getClassName());
			System.out.println(stack[i].getLineNumber());
			System.out.println(stack[i].getFileName());
			System.out.println("");			
		}
	}
	
	public void retornaUltimosDezMetodosClassesUtilizados(StackTraceElement[] stack){

		for(int i = 1; i < (stack.length < 10 ? stack.length : 10)-1;i++){
						
			System.out.println("-------------------------");
			System.out.println(stack[i].getMethodName());
			System.out.println(stack[i].getClassName());
			System.out.println(stack[i].getLineNumber());
			System.out.println(stack[i].getFileName());
			System.out.println("");			
		}
	}
}
