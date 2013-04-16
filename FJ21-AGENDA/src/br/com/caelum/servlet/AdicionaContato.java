package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.interfaces.Logica;

public class AdicionaContato extends HttpServlet implements Logica {
	public String execute (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		out.println("Seu nome é " + request.getParameter("nome"));
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String dataTexto = request.getParameter("data_nascimento");
		Date data = null;
		/*
		 * Lembrando que os Try, Catch
		 * Podem ser implementados de maneira global para o Tomcat
		 * Exemplo:
		 * 		<error-page>
		 * 			<exception-type>java.lang.nullPointerException</exception-type>
		 * 			<location>/erros.html</location>
		 * 		</error-page>
		 * 
		 * 		<error-page>
		 * 			<error-code>404</error-code>
		 * 			<location>/404.html</location>
		 * 		</error-page>
		 */
		try {
			data = new SimpleDateFormat("dd/mm/yyyy").parse(dataTexto);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		
		Contato c = new Contato();
		c.setNome(nome);
		c.setEmail(email);
		c.setDataNascimento(cal);
		
		new ContatoDao(request, response).adiciona(c);
		
		/* Manipulando Datas
		 * 
		 * String dataTexto = request.getParameter("data");
		 * Date data = new SDF("dd/mm/yyyy").parse(dataTexto);
		 * Calendar cal = Calendar.getInstance();
		 * cal.setTime(data)
		 */
		return "jstl.jsp";
		
		/* Request Dispatcher 
		RequestDispatcher rd = request.getRequestDispatcher("jstl.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}