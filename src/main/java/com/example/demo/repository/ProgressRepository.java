package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long>
{
	 Progress findByUseridAndStudyid(int userid,int studyid);

	 List <Progress> findByUserid(int userid);

}

