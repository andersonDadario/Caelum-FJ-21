package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.interfaces.Logica;


public class OiMundo extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 
	 * 1) Intenção
	 * 2) Nome da Intenção deve ser igual ao Nome da Classe
	 */
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		String opcode = request.getParameter("opcode");
		String nomeClasse = "br.com.caelum.servlet." + opcode;
		
		try{
			Class coringa = Class.forName(nomeClasse);
			Logica objeto = (Logica) coringa.newInstance();
			String at = objeto.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(at);
			rd.forward(request, response);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Erro: " + e);
		}
		
	}
}