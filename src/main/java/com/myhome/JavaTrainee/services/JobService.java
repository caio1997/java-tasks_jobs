package com.myhome.JavaTrainee.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	// Pesquisa todos as jobs de acordo com o peso das suas tasks
		public List<Job> findAll() {
			List<Job> list;
			list = jobRepository.findAll();
			Collections.sort(list,(job1, job2) -> job1.sum().compareTo(job2.sum()));
			Collections.reverse(list);
			return list;
		}
	
	// Pesquisa todos as jobs
	//public List<Job> findAll() {
	//	return jobRepository.findAll();
	//}

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
		
		jobRepository.save(obj);
		
		////Utilizado para inserir a chave do Job na Task
		obj.setTask(jobs.getTask());
		taskService.saveJob(obj);
		
		return obj;
	}

	// Deleta uma Job
	public String delete(Long id) {
		jobRepository.deleteById(id);
		return "OK";
	}
}
