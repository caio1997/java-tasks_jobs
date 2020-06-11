package com.myhome.JavaTrainee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.myhome.JavaTrainee.entities.Job;
import com.myhome.JavaTrainee.repositories.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private TaskService taskService;

	// Pesquisa todos as jobs
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	// Pesquisa o job pelo ID
	public Optional<Job> findById(Long id) {
		Optional<Job> jobs = jobRepository.findById(id);
		return jobs;
	}

	// Instancia uma Job
	public Job save(Job job) {
		Job objJob = new Job();
		objJob.setName(job.getName());
		objJob.setActive(job.isActive());
		jobRepository.save(objJob);
		
		//Utilizado para inserir a chave do Job na Task
		objJob.setTask(job.getTask());
		taskService.saveJob(objJob);
				
		return objJob;
	}

	// Instancia uma Job
	//public Job save(Job job) {
	//	Job objJob = new Job();
	//	objJob.setName(job.getName());
	//	objJob.setActive(job.isActive());
	//	jobRepository.save(objJob);

	//	return objJob;
	//}

	// Atualiza uma JOb
	public Job update(Long id, Job jobs) {
		Job obj = jobRepository.getOne(id);
		obj.setName(jobs.getName());
		obj.setActive(jobs.isActive());
		return jobRepository.save(obj);
	}

	// Deleta uma Job
	public String delete(Long id) {
		jobRepository.deleteById(id);
		return "OK";
	}
}
