package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Progress
{
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer userid;

	private Integer studyid;

	private Integer progresspercent;


}
