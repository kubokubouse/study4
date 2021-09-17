package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

	@Data
	@Entity
public class Targetuniver
{
		@Id
		// @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private Integer targetid;

		private Integer subjectid;

		@NotNull
		private Integer textpage;

		private String startstudy;

		private String endstudy;

}
