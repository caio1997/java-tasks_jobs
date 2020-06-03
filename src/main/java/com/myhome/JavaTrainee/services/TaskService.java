package com.myhome.JavaTrainee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.JavaTrainee.entities.Task;
import com.myhome.JavaTrainee.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	public Optional<Task> findById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task;
	}
	
	public Task save(Task task) {
		Task objTask = new Task();
		objTask.setName(task.getName());
		objTask.setWeight(task.getWeight());
		objTask.setCompleted(task.isCompleted());
		objTask.setCreatedAt(task.getCreatedAt());
		taskRepository.save(objTask);
		
		return objTask;
	}
	
	public Task update(Long id, Task task) {
		Task objTask = taskRepository.getOne(id);
		objTask.setName(task.getName());
		objTask.setWeight(task.getWeight());
		objTask.setCompleted(task.isCompleted());
		objTask.setCreatedAt(task.getCreatedAt());
		taskRepository.save(objTask);
		
		return objTask;
	}
	
	public String delete(Long id) {
		taskRepository.deleteById(id);
		return "OK";
	}

}
