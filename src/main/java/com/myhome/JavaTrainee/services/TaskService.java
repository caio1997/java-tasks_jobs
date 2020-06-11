package com.myhome.JavaTrainee.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.JavaTrainee.entities.Job;
import com.myhome.JavaTrainee.entities.Task;
import com.myhome.JavaTrainee.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// Pesquisar pela data da Task
	//Exemplo de URI: http://localhost:8080/task?date=2020-06-11
	public List<Task> findDate(Date date) {
		return taskRepository.findDate(date);
	}
	
	// Pesquisar pelo nome da Task
	//	public List<Task> findName(String name) {
	//		return taskRepository.findName(name);
	//	}

	// Pesquisa todos as tasks
	// public List<Task> findAll(){
	// return taskRepository.findAll();
	// }

	// Pesquisa a task pelo ID
	public Optional<Task> findById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task;
	}

	// Instancia uma task
	public Task save(Task task) {
		Task objTask = new Task();
		objTask.setName(task.getName());
		objTask.setWeight(task.getWeight());
		objTask.setCompleted(task.isCompleted());
		objTask.setCreatedAt(task.getCreatedAt());
		taskRepository.save(objTask);

		return objTask;
	}

	// Atualiza uma task
	public Task update(Long id, Task task) {
		Task objTask = taskRepository.getOne(id);
		objTask.setName(task.getName());
		objTask.setWeight(task.getWeight());
		objTask.setCompleted(task.isCompleted());
		objTask.setCreatedAt(task.getCreatedAt());
		return taskRepository.save(objTask);
	}

	// Deleta uma task
	public String delete(Long id) {
		taskRepository.deleteById(id);
		return "OK";
	}
	
	//Metodo para inserir um Job na Task
	public void saveJob(Job job) {
		List<Task> task = job.getTask();
		for(int x = 0; x < task.size(); x++) {
			Long id = task.get(x).getId();
			Task t = taskRepository.getOne(id);
			t.setJob(job);
			taskRepository.save(t);
		}
	}
}
