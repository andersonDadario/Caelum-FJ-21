package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.javabean.Contato;

public class ContatoDAO {
	public void maroto(Contato c) throws SQLException{
		String sql = "INSERT INTO contatos (nome,email,endereco,dataNascimento)" +
						"VALUES (?,?,?,?)";
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getNome());
		ps.setString(2, c.getTel());
		ps.setString(3, c.getEmail());
		ps.setDate(4, new Date(c.getData().getTimeInMillis()));
		ps.execute();
		System.out.println("Query executada!");
		ps.close();
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
