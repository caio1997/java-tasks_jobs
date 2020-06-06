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

import com.myhome.JavaTrainee.entities.Job;
import com.myhome.JavaTrainee.services.JobService;

@Controller
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;

	// Pesquisa todas as Jobs
	@GetMapping
	public ResponseEntity<List<Job>> findAll() {
		List<Job> list = jobService.findAll();
		return ResponseEntity.ok(list);
	}

	// Pesquisa o job pelo Id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Job>> findById(@PathVariable Long id) {
		Optional<Job> jobs = jobService.findById(id);
		return ResponseEntity.ok(jobs);
	}

	// Instancia uma job
	@PostMapping
	public ResponseEntity<Job> save(@RequestBody Job job) {
		Job objJob = jobService.save(job);
		return ResponseEntity.ok(objJob);
	}

	// Atualiza uma job
	@PutMapping("/{id}")
	public ResponseEntity<Job> update(@PathVariable Long id, @RequestBody Job job) {
		Job objJob = jobService.update(id, job);
		return ResponseEntity.ok(objJob);
	}

	// Deleta uma job
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		jobService.delete(id);
		return ResponseEntity.ok("Deleted ok");
	}
}
