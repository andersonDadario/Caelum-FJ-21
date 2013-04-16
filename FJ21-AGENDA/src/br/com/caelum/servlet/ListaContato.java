package br.com.caelum.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.interfaces.Logica;

public class ListaContato implements Logica {
	public String execute(HttpServletRequest request
			, HttpServletResponse response) throws ServerException, IOException, ServletException {
		
		List<Contato> lista = new ContatoDao().getLista();
		request.setAttribute("lista", lista);
		
		return "jstl.jsp";
	}
}
