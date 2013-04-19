package br.com.caelum.tarefas;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.caelum.tarefas.modelo.Usuario;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controller){
		
		HttpSession session = req.getSession();
		Usuario u = (Usuario)session.getAttribute("usuariologado");
		
		/* Verifica se ha usuario na Sessao */
		if(u != null){
			return true;
		}
		
		/* Liberando paginas */
		List<String> whitelist = new ArrayList<String>();
		whitelist.add("login");
		whitelist.add("efetuaLogin");
		
		for(String w : whitelist){
			if(req.getRequestURI().endsWith( w )){
				return true;
			}
		}
		
		/* Retorna para a pagina de Login */
		try {
			res.sendRedirect("login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
