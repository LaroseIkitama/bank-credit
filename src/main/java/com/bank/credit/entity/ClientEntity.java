package com.bank.credit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 150,nullable = false)
	private String firstName;
	
	@Column(length = 150,nullable = false)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(length = 150,nullable = false)
	private String country;
	
	@Column(length = 150,nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String adress;
	
	@OneToMany(mappedBy = "client")
	private List<CreditEntity> credits;
}
