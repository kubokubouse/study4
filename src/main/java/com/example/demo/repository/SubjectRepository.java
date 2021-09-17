package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>
{
	 Subject findById(int id);

	 //List <Subject> findByUserid(int id);

}

