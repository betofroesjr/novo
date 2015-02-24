package com.model.servico;
import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.persistence.IUsuarioDao;

@Service
public class ServicoGenerico implements IServicoGenerico{
	
	@Autowired private IUsuarioDao dao;
		
	public Connection getConexao() {
		return dao.getConexao();
	}
}