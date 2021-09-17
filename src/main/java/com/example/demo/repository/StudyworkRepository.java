package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Studywork;

public interface StudyworkRepository extends JpaRepository<Studywork, Long>
{
	Studywork findById(int id);
}

