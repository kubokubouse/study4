package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

	@Data
	@Entity
public class Univercity_Name
{
		@Id
		// @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private String name;
}
