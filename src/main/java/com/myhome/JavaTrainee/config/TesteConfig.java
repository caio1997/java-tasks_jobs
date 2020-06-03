package com.myhome.JavaTrainee.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.myhome.JavaTrainee.entities.Task;
import com.myhome.JavaTrainee.repositories.TaskRepository;

@Configuration
@Profile("dev")
public class TesteConfig implements CommandLineRunner{
	
	Date data = new Date();
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Criando os tasks
		Task t1 = new Task(null, "Task1", 5, false, data);
		Task t2 = new Task(null, "Task2", 6, false, data);
		Task t3 = new Task(null, "Task3", 4, true, data);
		Task t4 = new Task(null, "Task4", 2, true, data); 
		Task t5 = new Task(null, "Task5", 9, false, data);
		Task t6 = new Task(null, "Task6", 6, true, data);
		Task t7 = new Task(null, "Task7", 1, true, data);
		Task t8 = new Task(null, "Task8", 7, false, data);

		//Salvando as tasks vinculadas aos jobs
		taskRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8));
	}

}
