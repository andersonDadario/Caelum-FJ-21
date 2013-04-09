package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21"
					, "root"
					, ""
			);
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}

/* CTRL + SHIFT + O = Resolve dependências
 * CTRL + SHIFT + S = Salva todos os arquivos
 * CTRL + . = Ir direto ao Erro
 * CTRL + 1 = Autofix
 * CTRL + ESPAÇO = Autocomplete
 * CTRL + N = Cria algo novo :)
 * CTRL + 3 + ggas = Gerador de Getters/Setters
 * JAVABEAN (POJO) = Classe com getters/setters, variaveis.
*/
