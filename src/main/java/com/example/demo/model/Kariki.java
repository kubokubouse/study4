package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kariki
{
	 @Id
	 private int id;

	 private String subjectname;

	 private String startstudy;

	 private String endstudy;

	 private Integer progresspercent;

	 private Integer studyid;

	 private String bunya;


}
