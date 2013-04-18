package br.com.caelum.tarefas;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class HelloController {
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		//if(result.hasFieldErrors("descricao")){
		if(result.hasErrors()){
			return "formulario";
		}
		
		new JdbcTarefaDao().adiciona(tarefa);
		return "adicionado";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa, Model model){
		tarefa = new JdbcTarefaDao().buscaPorId(tarefa.getId());
		model.addAttribute("tarefa",tarefa);
		//return "forward:listaTarefas";
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("formulario")
	public String formulario(){
		return "formulario";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		List<Tarefa> lista = new JdbcTarefaDao().lista();
		model.addAttribute("lista", lista);
		
		return "listaTarefas";
	}
}
