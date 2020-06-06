package com.myhome.JavaTrainee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myhome.JavaTrainee.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
