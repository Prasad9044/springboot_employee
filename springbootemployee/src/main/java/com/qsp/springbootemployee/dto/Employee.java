package com.qsp.springbootemployee.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name can't be Blank")
	@NotNull(message = "Name can't be Null")
	private String name;
	@Column(unique = true)
//	@Pattern(regexp = "[6-9][0-9]{9}")=> regexp can be used only on String type data
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@Column(unique = true)

	@Email(regexp = "[a-z0-9.-_$%]+@[a-z0-9]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String email;
	@NotBlank(message = "Address can't be Blank")
	@NotNull(message = "Address can't be Null")
	private String address;
	@Min(value = 1)
	private double salary;
	private char grade;
}
