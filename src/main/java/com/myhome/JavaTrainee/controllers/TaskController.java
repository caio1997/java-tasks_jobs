package com.myhome.JavaTrainee.controllers;

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

import com.myhome.JavaTrainee.entities.Task;
import com.myhome.JavaTrainee.services.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		List<Task> list = taskService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> findById(@PathVariable Long id){
		Optional<Task> task = taskService.findById(id);
		return ResponseEntity.ok(task);
	}
	
	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task task){
		System.out.println("teste");
		Task objTask = taskService.save(task);
		return ResponseEntity.ok(objTask);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
		Task objTask = taskService.update(id, task);
		return ResponseEntity.ok(objTask);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		taskService.delete(id);
		return ResponseEntity.ok("Deleted ok");
	}
}
