package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.javabean.Contato;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		Contato c = new Contato();
		c.setNome("Anderson Dadario ");
		c.setTel("1234-5678");
		c.setEmail("a@a.com");
		c.setData(Calendar.getInstance()); 
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.maroto(c);
	}
}
