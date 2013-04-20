package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AdicionaTarefa {
	public static void main(String[] args) {
	
	    Tarefa tarefa = new Tarefa();
	    tarefa.setDescricao("Estudar JPA");
	    tarefa.setFinalizado(true);
	    tarefa.setDataFinalizacao(Calendar.getInstance());
	
	    EntityManagerFactory factory = Persistence.
	          createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();
	
	    manager.getTransaction().begin();
	    /*
	     *  Para alterar uma Tarefa
	     *  manager.merge(tarefa);
	     *  
	     *  Para remover uma Tarefa
	     *  manager.remove(tarefa)
	     */
	    
	    manager.persist(tarefa);
	    manager.getTransaction().commit();  
	
	    System.out.println("ID da tarefa: " + tarefa.getId());
	
	    manager.close();
	  }
}

