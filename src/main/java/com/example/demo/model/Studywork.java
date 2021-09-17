package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Studywork
{

	 @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 private Integer subjectid;

	 private String bunya;

	 private String textbook;


}
