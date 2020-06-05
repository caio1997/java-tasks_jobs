package com.myhome.JavaTrainee.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myhome.JavaTrainee.entities.Task;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	//SQL para pesquisar o nome da task
	@Query(value = "SELECT * FROM Task WHERE name = ?1", nativeQuery = true)
	List<Task> findName(String name);
}
