package com.myhome.JavaTrainee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhome.JavaTrainee.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
