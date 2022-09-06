package com.bank.credit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "credits")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CreditEntity {

	@Id
	private String creditNumber;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(nullable = false)
	private Integer duration;
	
	@ManyToOne
	private ClientEntity client;
}
