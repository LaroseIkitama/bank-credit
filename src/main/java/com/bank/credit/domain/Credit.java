package com.bank.credit.domain;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Credit {

	@NotNull(message="The credit number must not be null")
	private String creditNumber;
	
	@NotNull(message="Amount must not be null")
	private Double amount;
	
	@NotNull(message="The duration must not be null")
	private Integer duration;
	
	
	private Client client;
}
