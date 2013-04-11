package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OiMundo extends HttpServlet {
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>" +
				"<form action=\"adicionaContato\" method=\"post\">" + 
				"Nome: <input type=\"text\" name=\"nome\" /> <br/>" + 
				"Email: <input type=\"text\" name=\"email\" /> <br/>" + 
				"Data: <input type=\"text\" name=\"data_nascimento\" /> <br/>" +
				"<input type=submit value=Enviar /></form>" + 
				"</html>"
		);
	}
}