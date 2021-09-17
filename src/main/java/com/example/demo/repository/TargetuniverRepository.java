package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Targetuniver;

public interface TargetuniverRepository extends JpaRepository<Targetuniver, Long>
{
	List<Targetuniver> findByTargetid(int targetid);

	Targetuniver findByTargetidAndSubjectid(int targetid,int subjectid);

}

