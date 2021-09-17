package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personaldata")
public class User
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	 @Column
	 @NotBlank
	 @Size(max = 60)
	  private String lastname;

	 @Column
	 @NotBlank
	 @Size(max = 60)
	  private String firstname;

	 @Column
	 @NotNull
	 @Max(2)
	 @Min(0)
	  private Integer grade;

	 @Column
	 @NotNull
	 @Max(2)
	 @Min(0)
	  private Integer target;

	 @Column
	 @NotBlank
	 @Max(100)
	 @Min(0)
	  private String hensachi;

	 @Column
	 @NotBlank
	 @Pattern(regexp = "^([0-9]{3}[-]?[0-9]{4})?$")
	  private String postnumber;


	 @Column
	 @NotBlank
	  private String address;

	  @Column
	  @NotNull
	  @Max(1)
	  @Min(0)
	  private Integer sex;


	  @Column
	  @NotBlank
	  @Email
	  private String email;


	  @Column
	  @NotBlank
	  private String password;

}
