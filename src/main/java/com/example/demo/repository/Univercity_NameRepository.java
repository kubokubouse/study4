package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Univercity_Name;

public interface Univercity_NameRepository extends JpaRepository<Univercity_Name, Long>
{
	 Univercity_Name findById(int id);


}

