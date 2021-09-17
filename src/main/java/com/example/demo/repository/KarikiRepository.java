package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Kariki;

public interface KarikiRepository extends JpaRepository<Kariki, Long>
{
	@Query(value ="SELECT * from progress as a "
    		  +" join studywork as b on a.studyid=b.Id "
  		  +" join personaldata as c on a.userid=c.ID "
  		  +" join subject  as d on b.subjectid=d.Id "
  		  +"join targetuniver as e on e.targetid=c.target and e.subjectid=b.id  "
  		  +" where a.userid=?1",
	        nativeQuery = true)
	    List<Kariki> findByUserid(int uesrid);
}

