package com.myhome.JavaTrainee.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myhome.JavaTrainee.entities.Task;
import com.myhome.JavaTrainee.repositories.TaskRepository;
import com.myhome.JavaTrainee.services.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskRepository taskRepository;
	
	//Pesquina pelo nome da Task
	@GetMapping
	public ResponseEntity<List<Task>> findName(@RequestParam String name){
		List<Task> list = taskService.findName(name);
		return ResponseEntity.ok(list);
	}
	
	//Pesquisa todas as tasks
	//@GetMapping
	//public ResponseEntity<List<Task>> findAll(){
	//	List<Task> list = taskService.findAll();
	//	return ResponseEntity.ok(list);
	//}
	
	//Pesquisa a task pelo Id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> findById(@PathVariable Long id){
		Optional<Task> task = taskService.findById(id);
		return ResponseEntity.ok(task);
	}
	
	//Instancia uma task
	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task task){
		System.out.println("teste");
		Task objTask = taskService.save(task);
		return ResponseEntity.ok(objTask);
	}
	
	
	//Atualiza uma task
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
		Task objTask = taskService.update(id, task);
		return ResponseEntity.ok(objTask);
	}
	
	//Deleta uma task
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		taskService.delete(id);
		return ResponseEntity.ok("Deleted ok");
	}
}
