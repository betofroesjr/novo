package com.relatorio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.servico.IServicoGenerico;


@Controller
@Scope("request")
public class GenericoRel {
	// Caminho base
	private String path;
	// Caminho para o package onde estão armazenados os relatorios Jarper
	private String pathToReportPackage;
	 // Array de bytes que armazenará o conteúdo do arquivo PDF
	private byte[] conteudoPdf;
	 // Caminho completo do arquivo informado pelo usuário.
     // Ex: C:\Meus Documentos\boletim.pdf
    private String arquivo;
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
    
    @Autowired private IServicoGenerico servicoGenerico;

	// Recupera os caminhos para que a classe possa encontrar os relat�rios
	public GenericoRel() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.path = session.getServletContext().getRealPath("/jasper");
		this.pathToReportPackage = this.path;
		System.out.println(path);
	}

	// Imprime/gera uma lista de Clientes
	public void imprimir(String arquivo, Collection<?> collection) throws Exception {
		ImageIcon gto = new ImageIcon(getClass().getResource("/report/SimboloFundacaoTiradentes.jpg"));
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("logo", gto.getImage());

		JRDataSource dataSource = null;

		if (collection != null && collection.size() > 0) {
			dataSource = new JRBeanCollectionDataSource(collection);
		}

		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "/" + arquivo + ".jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, parametro,	dataSource);
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition", "attachment; filename=Relatorio_" + arquivo + ".pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void imprimir(String arquivo, Long id) throws Exception {

		ImageIcon gto = new ImageIcon(getClass().getResource("/report/SimboloFundacaoTiradentes.jpg"));
		Map<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("logo", gto.getImage());
		parametro.put("id", id);
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "/" + arquivo + ".jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, parametro, servicoGenerico.getConexao());
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition", "attachment; filename=Relatorio_" + arquivo + ".pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void imprimir(String arquivo, Map<String, Object> parametro) throws Exception {

		ImageIcon gto = new ImageIcon(getClass().getResource("/report/SimboloFundacaoTiradentes.jpg"));
		parametro.put("logo", gto.getImage());
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "/" + arquivo + ".jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, parametro, servicoGenerico.getConexao());
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition", "attachment; filename=Relatorio_" + arquivo + ".pdf");
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public void importarArquivo() {
		try {

		// Cria um objeto File a partir do caminho especificado
         File file = new File(arquivo);

         // Inicializa o array bytes com o tamanho do arquivo especificado.
         // Note a conversao para int, restringindo a capacidade maxima do
         // arquivo em 2 GB
         conteudoPdf = new byte[(int) file.length()];

         // Cria um InputStream a partir do objeto File
         InputStream is = new FileInputStream(file);

         // Aqui o InputStream faz a leitura do arquivo, transformando em um
         // array de bytes
         is.read(conteudoPdf);

         // Fecha o InputStream, liberando seus recursos
         is.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
	}
	
	//Não funcionou...
	public void visualizarPdf() {

		FacesContext fc = FacesContext.getCurrentInstance();
	
		// Obtem o HttpServletResponse, objeto responsável pela resposta do
		// servidor ao browser
		HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();

		// Limpa o buffer do response
		response.reset();

		// Seta o tipo de conteudo no cabecalho da resposta. No caso, indica que o
		// conteudo sera um documento pdf.
		response.setContentType("application/pdf");

		// Seta o tamanho do conteudo no cabecalho da resposta. No caso, o
		// tamanho
		// em bytes do pdf
		response.setContentLength(conteudoPdf.length);

		// Seta o nome do arquivo e a disposição: "inline" abre no próprio
		// navegador.
		// Mude para "attachment" para indicar que deve ser feito um download		
		response.setHeader("Content-disposition", "attachment; filename=arquivo.pdf");
		try {
			// Envia o conteudo do arquivo PDF para o response
			response.getOutputStream().write(conteudoPdf);

			// Descarrega o conteudo do stream, forçando a escrita de qualquer
			// byte ainda em buffer
			response.getOutputStream().flush();

			// Fecha o stream, liberando seus recursos
			response.getOutputStream().close();

			// Sinaliza ao JSF que a resposta HTTP para este pedido já foi
			// gerada
			fc.responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 public void downloadPDF() throws IOException {

	        // Prepare.
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = facesContext.getExternalContext();
	        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	        
	        File file = new File(getArquivo());
	        BufferedInputStream input = null;
	        BufferedOutputStream output = null;

	        try {
	            // Open file.
	            input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);

	            // Init servlet response.
	            response.reset();
	            response.setHeader("Content-Type", "application/pdf");
	            response.setHeader("Content-Length", String.valueOf(file.length()));
	            response.setHeader("Content-Disposition", "inline; filename=\"" + getArquivo() + "\"");
	            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

	            // Write file contents to response.
	            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	            int length;
	            while ((length = input.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }

	            // Finalize task.
	            output.flush();
	        } finally {
	            // Gently close streams.
	            close(output);
	            close(input);
	        }

	        // Inform JSF that it doesn't need to handle response.
	        // This is very important, otherwise you will get the following exception in the logs:
	        // java.lang.IllegalStateException: Cannot forward after response has been committed.
	        facesContext.responseComplete();
	    }

	    // Helpers (can be refactored to public utility class) ----------------------------------------

	    private static void close(Closeable resource) {
	        if (resource != null) {
	            try {
	                resource.close();
	            } catch (IOException e) {
	                // Do your thing with the exception. Print it, log it or mail it. It may be useful to 
	                // know that this will generally only be thrown when the client aborted the download.
	                e.printStackTrace();
	            }
	        }
	    }
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPathToReportPackage() {
		return pathToReportPackage;
	}

	public void setPathToReportPackage(String pathToReportPackage) {
		this.pathToReportPackage = pathToReportPackage;
	}
}
