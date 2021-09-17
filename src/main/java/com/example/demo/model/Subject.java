package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Subject
{

	 @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 private String subjectname;

//元のDBはdateで定義づけていることに注意
	 private String exam1;

	 private String exam2;
}
