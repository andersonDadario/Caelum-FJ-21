package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.javabean.Contato;

public class ContatoDAO {
	public List<Contato> getLista() throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		String sql = "SELECT * FROM contatos";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Contato> lista = new ArrayList();
		
		while(rs.next()){
			Contato c = new Contato();
			c.setNome(rs.getString("nome"));
			lista.add(c);
		}
		
		return lista;
	}
	
	public void maroto(Contato c) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		String sql = "INSERT INTO contatos (nome,email,endereco,dataNascimento)" +
				"VALUES (?,?,?,?)";
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
