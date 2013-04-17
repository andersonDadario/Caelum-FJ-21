package br.com.caelum.tarefas;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class HelloController {
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		if(result.hasFieldErrors("descricao")){
			return "formulario";
		}
		
		new JdbcTarefaDao().adiciona(tarefa);
		return "adicionado";
	}
	
	@RequestMapping("formulario")
	public String formulario(){
		return "formulario";
	}
}
