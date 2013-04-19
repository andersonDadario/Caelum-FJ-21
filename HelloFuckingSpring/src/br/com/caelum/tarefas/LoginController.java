package br.com.caelum.tarefas;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	@RequestMapping("login")
	public String login(){
		return "login/formulario";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario u, HttpSession session, Model model){
		if(new JdbcUsuarioDao().existeUsuario(u)){
			session.setAttribute("usuariologado",u);
			return "redirect:listaTarefas";
		} else {
			model.addAttribute("erro","Cara, deu erro");
			return "login/formulario";
		}
	}
	
	@RequestMapping("logout")
	public String efetuaLogout(HttpSession session){
		session.invalidate();
		return "login/formulario";
	}
}
