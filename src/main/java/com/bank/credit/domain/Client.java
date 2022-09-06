package com.bank.credit.domain;



import javax.validation.constraints.NotNull;

import com.bank.credit.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
	
	
	private Long id;
	
	@NotNull(message="The first name must not be null")
	private String firstName;
	
	@NotNull(message="The last name must not be null")
	private String lastName;
	
	@NotNull(message="The gender must be FEMALE or MALE")
	private Gender gender;
	
	@NotNull(message="The country must not be null")
	private String country;
	
	@NotNull(message="The city must not be null")
	private String city;
	
	@NotNull(message="The adress must not be null")
	private String adress;
	
}
