package com.myhome.JavaTrainee.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myhome.JavaTrainee.entities.Task;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	//SQL para pesquisar o nome da task
	@Query(value = "SELECT * FROM task WHERE created = ?1", nativeQuery = true)
	List<Task> findDate(Date date);
}
